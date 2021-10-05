package leetCode.regular.findLongestWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 布谷
 * @Date: 2021/9/14 14:27
 * @Description:
 */
public class Solution {


    public String findLongestWord(String s, List<String> dictionary) {
        String maxSubString = "";
        int maxLength = 0;
        for(String dict : dictionary){
            int pre = 0;int suf = 0;
            while (pre < dict.length() && suf < s.length()){
                if(dict.charAt(pre) == s.charAt(suf)){
                    if(pre == dict.length() - 1){
                        if(dict.length() == maxLength){
                            maxSubString = maxStr(dict,maxSubString);
                        }
                        if(dict.length() > maxLength){
                            maxLength = dict.length();
                            maxSubString = dict;
                        }
                    }
                    pre ++;
                }
                suf++;
            }
        }
        return maxSubString;

    }

    private String maxStr(String dict, String maxSubString) {
        for(int i = 0;i < dict.length();i++){
            if(dict.charAt(i) < maxSubString.charAt(i)){
                return dict;
            }
            if(dict.charAt(i) > maxSubString.charAt(i)){
                return maxSubString;
            }
        }
        return maxSubString;
    }

    public static void main(String[] args) {
        String str = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","appla","monkey","plea","appla","apcpe");
        System.out.println(new Solution().findLongestWord(str,dictionary));
    }

}
