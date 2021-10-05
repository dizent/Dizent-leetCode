package LCP.game.reverseString;

/**
 * @Auther: 布谷
 * @Date: 2021/9/12 10:39
 * @Description:
 */
public class Solution {
    public String reversePrefix(String word, char ch) {
        char[] sChars = word.toCharArray();
        int end = 0;
        for(int i = 0,n = sChars.length; i< n; i ++){
            if(sChars[i] == ch){
                end = i;
                break;
            }
        }
        return reverseString(word,0,end);
    }

    private String reverseString(String word,int start,int end){
        StringBuilder sb = new StringBuilder();
        int index = end;
        while(index >= start){
            sb.append(word.charAt(index));
            index -= 1;
        }
        index = end + 1;
        while(index < word.length()){
            sb.append(word.charAt(index));
            index += 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word = "abcdefg";
        char ch = 'd';
        System.out.println(new Solution().reversePrefix(word,ch));
    }
}
