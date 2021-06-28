package leetCode.easy.largestOddNumber;

/**
 * @Auther: 布谷
 * @Date: 2021/6/25 16:36
 * @Description:
 */
public class Solution {

    public String largestOddNumber(String num) {
        for(int i = num.length() - 1; i >= 0; i--){
            int digit = num.charAt(i) - '0';
            if(digit % 2 != 0){
                return num.substring(0,i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "3572456873289578948325840328504";
        System.out.println(new Solution().largestOddNumber(num));
    }
}
