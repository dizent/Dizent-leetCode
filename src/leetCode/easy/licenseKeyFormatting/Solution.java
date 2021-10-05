package leetCode.easy.licenseKeyFormatting;

/**
 * @Auther: 布谷
 * @Date: 2021/10/4 15:13
 * @Description:
 */
public class Solution {
    /**
     * 思路：
     * 1. 从后往前遍历；如果碰到破折号，则删除
     * 2. 每遍历 k 个元素，便加一个破折号
     * 3.
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int currLength = 0;
        for(int i = s.length() - 1; i >= 0; i --){
            char c = s.charAt(i);
            if (c != '-') {
                if (c >= 'a' && c <= 'z') {
                    c -= 32;
                }
                sb.append(c);
                currLength += 1;
                if (currLength == k) {
                    sb.append('-');
                    currLength = 0;
                }
            }
        }
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '-'){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "------sdfasfdsa--";
        int k = 2;
        System.out.println(new Solution().licenseKeyFormatting(s,k));
    }
}
