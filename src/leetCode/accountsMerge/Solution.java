package leetCode.accountsMerge;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.*;

public class Solution {



    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailMap = new HashMap<String,List<Integer>>();
        boolean endFlag = true;
        for(int index = 0;index<accounts.size();index++){
            List<String> o = accounts.get(index);
            for(int i = 1;i<o.size();i++){
                emailMap.computeIfAbsent(o.get(i), k -> new ArrayList<>());
                emailMap.get(o.get(i)).add(index);
                if(emailMap.get(o.get(i)).size() >1){
                    endFlag = false;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        if(endFlag){
            for(int i = 0;i<accounts.size();i++) {
                String name = accounts.get(i).get(0);
                List<String> oneList = accounts.get(i).subList(1,accounts.get(i).size());
                sortEmail(result, name, oneList);
            }
            return result;
        }
        for(int i = 0;i<accounts.size();i++) {
            Set<Integer> hasSet = new HashSet<>();
            for(int j = 1;j<accounts.get(i).size();j++){
                hasSet.addAll(emailMap.get(accounts.get(i).get(j)));
            }
            Set<String> one = new HashSet<>();
            if(!hasSet.isEmpty()) {
                String name = accounts.get(i).get(0);
                hasSet.forEach(has -> {
                    if(!accounts.get(has).isEmpty()) {
                        one.addAll(accounts.get(has).subList(1, accounts.get(has).size()));
                        accounts.set(has, Collections.emptyList());
                    }
                });
                List<String> oneList = new ArrayList<> (one);
                sortEmail(result, name, oneList);
            }
        }
        return accountsMerge(result);
    }

    private void sortEmail(List<List<String>> result, String name, List<String> oneList) {
        oneList.sort((o1, o2) -> {
            char[] chars1 = o1.toCharArray();
            char[] chars2 = o2.toCharArray();
            int i1 = 0;
            while (i1 < chars1.length && i1 < chars2.length) {
                if (chars1[i1] > chars2[i1]) {
                    return 1;
                } else if (chars1[i1] < chars2[i1]) {
                    return -1;
                } else {
                    i1++;
                }
            }
            if (i1 == chars1.length) {  //o1到头
                return -1;
            }
            if (i1 == chars2.length) { //o2到头
                return 1;
            }
            return 0;
        });
        List<String> nameList = new ArrayList();
        nameList.add(name);
        nameList.addAll(oneList);
        result.add(nameList);
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<List<String>>() {
        };
        String str =
    "[[\"David\",\"David0@m.co\",\"David1@m.co\"],[\"David\",\"David3@m.co\",\"David4@m.co\"],[\"David\",\"David4@m.co\",\"David5@m.co\"],[\"David\",\"David2@m.co\",\"David3@m.co\"],[\"David\",\"David1@m.co\",\"David2@m.co\"]]";
        accounts = JSONObject.parseObject(str,ArrayList.class);
        System.out.println(JSONObject.toJSONString(new Solution().accountsMerge(accounts)));
    }
}
