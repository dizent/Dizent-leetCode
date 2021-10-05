package leetCode.regular.fractionToDecimal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Auther: 布谷
 * @Date: 2021/10/3 20:24
 * @Description:
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long)numerator;
        long denominatorLong = (long)denominator;
        if(numerator == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if((numerator ^ denominator) < 0){
            sb.append("-");
        }
        sb.append(decimal(Math.abs(numeratorLong),Math.abs(denominatorLong),0));
        if(startIndex > 0){
            int pointIndex = sb.indexOf(".");
            System.out.println("pointIndex is : " + pointIndex +" startIndex is : "+startIndex);
            sb.insert(pointIndex + startIndex ,"(");
            sb.append(")");
        }
        return sb.toString();
    }

    Map<Long,Integer> intMap = new LinkedHashMap<>();
    int startIndex = 0;
    boolean floatFlag = true;


    /**
     * 长除法思路：
     * 先计算整数，可以直接除
     * 计算小数，将余数 * 10 ，除以被除数，得到一个整数和余数，当余数为0，停止计算
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String decimal(long numerator, long denominator,int index) {
        StringBuilder sb = new StringBuilder();
        if(intMap.get(numerator) != null){
            startIndex = intMap.get(numerator);
            System.out.println("startIndex has value" + startIndex);
            return "";
        }
        long res = numerator / denominator;
        long divide = numerator % denominator;
        if(!floatFlag){
            intMap.put(numerator,index);
        }
        sb.append(res);
        if(divide == 0){
            return sb.toString();
        }
        if(floatFlag){
            floatFlag = false;
            sb.append(".");
        }
        sb.append(decimal(divide * 10 ,denominator,index + 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        int numerator = 1;
        int denominator = 2;
        System.out.println(new Solution().fractionToDecimal(numerator, denominator));
    }
}
