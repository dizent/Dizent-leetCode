要求：
（1）一个小时，1,2任选一题，3,4任意一题；
（2）尽可能展示你的编码能力（Java语法、编码风格等）；
1 写一个函数将一个单向链表进行反向。要求自行编写反向的过程和设计数据结构，不要外部包和辅助函数来处理。
2 两个线程交替打印1-100的整数，一个打印奇数，一个打印偶数，要求输出结果有序。
3 场景描述： 用户在支付宝拥有多种支付方式（余额、红包、余额宝等，每种支付工具分布在不同系统），每种支付方式通过调用远程服务获取可用性。在外部资源环境不变情况下，请设计程序以最短响应时间获得尽可能多的可用支付方式列表。
//补充：假定支付方式可用性咨询接口统一为
ConsultResult  PaymentRemoteSerivce.isEnabled(String userId,String paymentType); 
// 返回结果
public class ConsultResult {
/** 咨询结果是否可用*/
private boolean isEnable;
/** 错误码 */
private String errorCode;
}
/**
 * 过滤不可用支付方式类型，返回可用的支付方式
 * @param allPaymentTypeList 支付方式类型列表
 * @return 可用支付方式类型列表
 */
public List<String> filterDisablePayment(String userId,List<String> allPaymentTypeList){
        //: TODO 完成此处的代码
}
4 尝试用java编写一个转账接口，传入主要业务参数包括转出账号，转入账号，转账金额，完成转出和转入账号的资金处理，该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确。