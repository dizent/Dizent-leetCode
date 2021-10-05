package leetCode.easy.lengthOfLastWord;

/**
 * @Auther: 布谷
 * @Date: 2021/9/21 16:37
 * @Description:
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int end = 1 << 30;
        int start = 0;
        while(index >= start){
            if(s.charAt(index) != ' ' && end > s.length()){
                end = index;
            }
            if(end <= s.length() - 1 && s.charAt(index) == ' '){
                start = index + 1;
                break;
            }
            index --;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        String s = "hello world ";
        System.out.println(new Solution().lengthOfLastWord(s));
    }
}
