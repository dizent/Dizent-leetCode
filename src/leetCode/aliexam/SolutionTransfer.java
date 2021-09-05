package leetCode.aliexam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 布谷
 * @Date: 2021/8/26 19:53
 * @Description:
 */
public class SolutionTransfer {


//    AccountService accountService = new AccountServiceImpl();
//
//    public Boolean transfer(Integer fromAccount, Integer toAccount, BigDecimal transferAmount){
//        Boolean result = false;
//
//        Integer minAccount = Math.min(fromAccount,toAccount);
//        Integer maxAccount = Math.max(fromAccount,toAccount);
//        synchronized (minAccount){
//            synchronized (maxAccount){
//                BigDecimal fromBalance = accountService.getAccountBalance(fromAccount);
//                if(fromBalance.compareTo(transferAmount) >= 0){
//                    accountService.subAccountBalance(fromAccount,transferAmount);
//                    accountService.addAccountBalance(fromAccount,transferAmount);
//                    result = true;
//                }
//            }
//        }
//        return result;
//    }
}
