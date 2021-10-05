package leetCode.easy.maxSubArray;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/9/24 14:56
 * @Description:
 */
public class Solution {

    public int maxSubArray(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(new Solution().maxSubArray(arr));
    }

}
