package leetCode.regular.isPossible;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isPossible(int[] nums) {
        if(nums.length<3){
            return false;
        }
        if(nums[nums.length-1]-nums[0] < 2){
            return false;
        }

        for(int i = 0;i<nums.length;i++){
            List<Integer> res = new ArrayList<>();
            res.add(nums[i]);
            for (int j = i+1;j<nums.length;j++){
                boolean repeatFlag = false;
                if(nums[j] - nums[j-1] > 1 || nums[j] - nums[j-1] < 0){
                    return false;
                }
                if(nums[j] - nums[j-1] == 1){
                    if(!repeatFlag) {
                        res.add(nums[j]);
                    }
                }
                if(nums[j] - nums[j-1] == 0){
                    repeatFlag = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] params = new int[]{};
        System.out.println(new Solution().isPossible(params));
    }
}
