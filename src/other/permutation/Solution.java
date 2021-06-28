package other.permutation;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class Solution {

    public String[] permutation(String s) {
        LinkedList strs = new LinkedList();
        for(Character c :s.toCharArray()){
            strs.add(c);
        }
        List<String> afterStrs = permutation(strs);
        String[] result = new String[afterStrs.size()];
        afterStrs.toArray(result);
        return result;
    }

    public List<String> permutation(LinkedList<Character> sChars){
        List<String> result = new ArrayList<>();
        if(sChars.size() == 1){
            result.add(String.valueOf(sChars.get(0)));
        }
        Set<Character> head = new HashSet<>();
        for(int i = 0; i < sChars.size(); i++){
            if(head.contains(sChars.get(i))){
                continue;
            }
            char startChar = sChars.get(i);
            sChars.remove(i);
            List<String> sonStrs = permutation(sChars);
            for(String sonStr:sonStrs){
                result.add(startChar + sonStr);
            }
            sChars.add(i,startChar);
            head.add(startChar);
        }
        return result;
    }


    public static void main(String[] args) {
        long startMills = System.currentTimeMillis();
        String s = "abcb";
        String[] strs = new Solution().permutation(s);
        long endMills = System.currentTimeMillis();
        System.out.printf("一共用了 %d ms",endMills - startMills);
        System.out.println(JSONObject.toJSONString(strs));
    }
}
