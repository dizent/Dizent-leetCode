package leetCode.regular.findSubsequences;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List result = new ArrayList();
        if(nums.length < 2){
            return null;
        }
        if(nums.length == 2){
            if(nums[0] <= nums[1]){
                result.add(Arrays.asList(nums));
                return result;
            }
        }
        for(int i = 0 ;i < nums.length - 2 ; i ++){
            List<Integer> subResult = new ArrayList<>();
            subResult.add(nums[i]);
            for(int j = i + 1 ;j < nums.length - 1; j++){
                if(nums[i] <= nums[j]){
                    subResult.add(nums[j]);
                }
            }
        }
        return null;
    }

    public List<List<Integer>> dfs(int[] nums){
        int size = nums.length;
        for(int i = 0;i<size-1;i++){

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(JSONObject.toJSONString(new Solution().findSubsequences(nums)));
    }
}
