package leetCode.regular.getSum;

import java.util.logging.Logger;

/**
 * @Auther: 布谷
 * @Date: 2021/9/26 09:43
 * @Description: 371. 两整数之和
 */
public class Solution {

    Logger logger = Logger.getLogger("Solution");

    public int getSum(int a,int b){
        while(b != 0){
            logger.info("\na: " + a +"\t"+ Integer.toBinaryString(a) + "\nb: "+ b +"\t"+ Integer.toBinaryString(b));
            int carry = (a & b) << 1;
            logger.info("\ncarry: " + carry +"\t"+ Integer.toBinaryString(carry));
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 30;
        int b = 15;
        System.out.println(new Solution().getSum(a,b));
    }
}
