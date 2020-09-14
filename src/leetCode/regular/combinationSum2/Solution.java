package leetCode.regular.combinationSum2;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class Solution {


    List<List<Integer>> result = new ArrayList<>();

    /**
     *
     * 思路：
     *
     * 组合总数I+结果去重
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //去重
        dfs(new ArrayList<>(),0,candidates,target);

        for(int i = result.size() - 1;i >= 1;i --){
            for(int j = i - 1;j >= 0;j--){
                List<Integer> resultI = result.get(i);
                List<Integer> resultJ = result.get(j);
                if(resultI.size() == resultJ.size()){
                    boolean remove = false;
                    for(int index = 0;index < resultI.size();index++){
                        if(!resultI.get(index).equals(resultJ.get(index))){
                            break;
                        }
                        if(resultI.get(index).equals(resultJ.get(index)) && index == resultI.size() - 1){
                            remove = true;
                        }
                    }
                    if(remove){
                        result.remove(i);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public void dfs(List<Integer> preSelect ,int preSum,int[] candidates,int target){
        if(preSum > target){
            return;
        }
        if(target == preSum){
            List<Integer> select = new ArrayList<Integer>(preSelect);
            select.sort(Comparator.comparingInt(o -> o));
            result.add(select);
            return;
        }
        for(int i = 0;i < candidates.length;i++){
            preSelect.add(candidates[i]);
            preSum += candidates[i];
            dfs(preSelect,preSum, Arrays.copyOfRange(candidates,i + 1,candidates.length),target);
            preSum -= candidates[i];
            preSelect.remove(preSelect.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(JSONObject.toJSONString(sol.combinationSum2(candidates,target)));
    }
}
