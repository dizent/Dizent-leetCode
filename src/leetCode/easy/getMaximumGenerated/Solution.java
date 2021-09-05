package leetCode.easy.getMaximumGenerated;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/8/23 10:07
 * @Description:
 */
public class Solution {

    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for(int i = 2;i <= n ;i++){
            if(i % 2 == 1){
                nums[i] = nums[(i - 1) / 2] + nums[(i - 1) / 2  + 1];
                max = Math.max(max,nums[i]);
            }else{
                nums[i] = nums[i / 2];
                max = Math.max(max,nums[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().getMaximumGenerated(n));
    }
}
