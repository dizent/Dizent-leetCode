package leetCode.regular.canJump;

/**
 * @Auther: 布谷
 * @Date: 2021/9/18 09:21
 * @Description:
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        int maxLength = 0;
        int index = 0;
        while(maxLength < nums.length - 1){
            if(maxLength < index){
                return false;
            }
            maxLength = Math.max(maxLength,nums[index] + index);
            index ++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,0};
        System.out.println(new Solution().canJump(nums));
    }
}
