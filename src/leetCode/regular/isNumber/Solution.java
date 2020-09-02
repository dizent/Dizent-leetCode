package leetCode.regular.isNumber;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * <p>
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class Solution {

    /**
     * 规则梳理：
     * <p>
     *    32  只能出现在最前和最后(可连续出现多次)，判断后去除
     * +  43  只能出现在最前方，不能和 - 连续出现
     * -  45  出现在数字最前方,不能和 + 连续出现
     * E  69  出现在中间，前为数字,后为整数，与e全局只能出现一个
     * e  101 出现在中间，前为数字,后为整数，与E全局只能出现一个
     * .  46  出现在最前，最后，或者中间，全局只能出现一个
     * 0  48  可以出现在最前方
     * 123456789    49-57    可以在任意位置出现
     * <p>
     * 思路：
     * 题目说明不够，下面的代码只能包含部分情况，已放弃
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        int EIndex = s.indexOf('E');
        int eIndex = s.indexOf('e');
        if(s.trim().isEmpty()){
            return false;
        }
        String[] splitStr = null;
        char endChar = s.charAt(s.length() - 1);
        char startChar = s.charAt(0);
        while(startChar == ' '){
            s = s.substring(1);
            startChar = s.charAt(0);
        }
        while(endChar == ' '){
            s = s.substring(0,s.length() - 1);
            endChar = s.charAt(s.length() - 1);
        }
        //开头和结尾不能有中间的字符
        if (startChar == 'E' || startChar == 'e') {
            return false;
        }
        if (endChar == 'E' || endChar == 'e' || endChar == '+' || endChar == '-') {
            return false;
        }
        if (EIndex != -1) {
            splitStr = s.split("E");
            if (splitStr.length > 2) {
                return false;
            }
        }
        if (eIndex != -1) {
            splitStr = s.split("e");
            if (splitStr.length > 2) {
                return false;
            }
        }
        if (splitStr != null) {
            //出现了分割
            return judgeDecimal(splitStr[0]) &&
                    judgeInteger(splitStr[1]);
        } else {
            return judgeDecimal(s);
        }
    }

    private boolean judgeInteger(String s) {
        int startChar = s.charAt(0);
        if(startChar != '+' && startChar != '-'){
            if (startChar < 48 || startChar > 57) {
                return false;
            }
        }
        for(int i = 1;i< s.length();i++){
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }

    public boolean judgeDecimal(String s) {
        int pointIndex = s.indexOf(".");
        if (pointIndex == -1) {
            return judgeInteger(s);
        }
        String[] splitStr = s.split("\\.");
        if (splitStr.length > 2) {
            return false;
        }
        String prefix = splitStr[0];
        if (prefix.length() != 0 && !judgeInteger(prefix)) {
            return false;
        }
        String suffix = splitStr[1];
        for (int i = 0; i < suffix.length(); i++) {
            if (suffix.charAt(i) < 48 || suffix.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"1."};
        Solution solution = new Solution();
        for(int i = 0;i < strs.length;i++) {
            System.out.println(strs[i] + "\t" +solution.isNumber(strs[i]));
        }
    }
}
