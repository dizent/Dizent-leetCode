package leetCode.regular.findUnsortedSubarray;

/**
 * @Auther: 布谷
 * @Date: 2021/8/3 10:17
 * @Description:
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int pre = 0;
        int after = nums.length - 1;
        for(int i = 1 ; i < nums.length;i++){
            if(nums[i - 1] > nums[i]){
                for(int j = i;j >= pre;j --){
                    if(nums[j] < nums[i]){
                        after = i;
                        break;
                    }
                }
            }
        }
        return after - pre;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}
