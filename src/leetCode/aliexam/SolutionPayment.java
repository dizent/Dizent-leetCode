package leetCode.aliexam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: 布谷
 * @Date: 2021/8/26 19:42
 * @Description:
 */
public class SolutionPayment {

    //3 场景描述： 用户在支付宝拥有多种支付方式（余额、红包、余额宝等，每种支付工具分布在不同系统），
    //每种支付方式通过调用远程服务获取可用性。在外部资源环境不变情况下，请设计程序以最短响应时间获得尽可能多的可用支付方式列表。
    //补充：假定支付方式可用性咨询接口统一为
    //ConsultResult PaymentRemoteSerivce.
    interface PaymentRemoteSerivce {

        ConsultResult isEnabled(String userId, String paymentType);
    }

    PaymentRemoteSerivce paymentRemoteSerivce = new PaymentRemoteSerivce() {
        @Override
        public ConsultResult isEnabled(String userId, String paymentType) {
            return new ConsultResult();
        }
    };

    // 返回结果
    public class ConsultResult {
        /**
         * 咨询结果是否可用
         */
        private boolean isEnable;
        /**
         * 错误码
         */
        private String errorCode;
    }

    /**
     * 过滤不可用支付方式类型，返回可用的支付方式
     *
     * @param allPaymentTypeList 支付方式类型列表
     * @return 可用支付方式类型列表
     */
    public List<String> filterDisablePayment(String userId, List<String> allPaymentTypeList) {
        //: TODO 完成此处的代码
        List<String> enablePaymentTypeList = new CopyOnWriteArrayList<>();
        allPaymentTypeList.stream().parallel().forEach(paymentType -> {
            ConsultResult consultResult = paymentRemoteSerivce.isEnabled(userId, paymentType);
            if (consultResult.isEnable) {
                enablePaymentTypeList.add(paymentType);
            }
        });
        return enablePaymentTypeList;
    }

    public List<String> filterDisablePaymentSecond(String userId, List<String> allPaymentTypeList) {
        //: TODO 完成此处的代码
        ExecutorService executor = Executors.newFixedThreadPool(allPaymentTypeList.size());
        List<String> enablePaymentTypeList = new CopyOnWriteArrayList<>();

        allPaymentTypeList.stream().parallel().forEach(paymentType -> {
            try {
                new GetPaymentTypeEnable(userId, paymentType).call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        return enablePaymentTypeList;
    }

    class GetPaymentTypeEnable implements Callable {

        String userId;

        String paymentType;

        public GetPaymentTypeEnable(String userId, String paymentType) {
            this.userId = userId;
            this.paymentType = paymentType;
        }

        @Override
        public ConsultResult call() throws Exception {
            return paymentRemoteSerivce.isEnabled(userId, paymentType);
        }
    }


}
