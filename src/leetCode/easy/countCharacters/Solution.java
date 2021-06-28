package leetCode.easy.countCharacters;

public class Solution {

    public int countCharacters(String[] words, String chars) {
        int[] times = new int[26];
        int result = 0;
        for(int i = 0; i < chars.length(); i++){
            times[chars.charAt(i) - 'a'] ++;
        }
        for(int i = 0;i < words.length; i++){
            int[] wordTimes = new int[26];
            int stydy = 1;
            for(int j = 0; j < words[i].length(); j++){
                wordTimes[words[i].charAt(j) - 'a'] ++;
                if(wordTimes[words[i].charAt(j) - 'a'] > times[words[i].charAt(j) - 'a']){
                    stydy = 0;
                    break;
                }
            }
            result += stydy;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(new Solution().countCharacters(words,chars));
    }
}
