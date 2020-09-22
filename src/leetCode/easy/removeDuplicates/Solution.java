package leetCode.easy.removeDuplicates;

import com.alibaba.fastjson.JSONObject;

public class Solution {


    /**
     * 原地算法去重
     *
     * 双指针，
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != nums[index]){
                index ++;
                nums[index] = nums[i];
            }
        }
        System.out.println(JSONObject.toJSONString(nums));
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
