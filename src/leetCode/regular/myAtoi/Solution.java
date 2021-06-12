package leetCode.regular.myAtoi;

class Solution {
    /**
     * 根据规则解读：
     * - 从前往后判断字符
     * - 第一个字符为数字或者 '-'号
     * - 往后判断数字字符，并且取出
     * - 遇到非数字或者字符串结尾结束循环
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("9223372036854775808"));
    }
}
