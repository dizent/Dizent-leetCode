package leetCode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 1081
 */
public class SmallestSubsequence {

    public static String function(String text){
        if(text.isEmpty()){
            return "";
        }
        char[] textChar = text.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ;i<textChar.length;i++){
            if(sb.indexOf(String.valueOf(textChar[i])) != -1){
                continue;
            }
            else{
                for(int j = sb.length() - 1; j >= 0; j--) {
                    if (text.indexOf(sb.charAt(j), i) != -1 && textChar[i] < sb.charAt(j)) {
                        sb.deleteCharAt(j);
                    }else{
                        break;
                    }
                }
                sb.append(textChar[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(function("leetcode"));
    }
}
