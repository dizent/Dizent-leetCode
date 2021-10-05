package LCP.game.countQuadruplets;

/**
 * @Auther: 布谷
 * @Date: 2021/9/5 11:12
 * @Description:
 */
public class Solution {

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i = 0;i < n - 3 ;i ++){
            for(int j = i + 1;j < n - 2;j++){
                for(int k = j + 1;k < n - 1;k++){
                    for(int l = k + 1;l < n;l++){
                        if(nums[i] + nums[j] + nums[k] == nums[l]){
                            result ++;
                        }
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3};
        System.out.println(new Solution().countQuadruplets(nums));
    }
}
