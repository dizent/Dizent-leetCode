package leetCode.regular.deleteAndEarn;

/**
 * @Auther: 布谷
 * @Date: 2021/9/17 22:52
 * @Description:
 */
public class Solution {

    public int deleteAndEarn(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int[] sums = new int[20001];
        for (int num : nums) {
            sums[num] += num;
        }
        int first = sums[0];
        int second = Math.max(sums[0],sums[1]);
        for(int i = 2;i<20001;i++){
            int temp = second;
            second = Math.max(first + sums[i],second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(new Solution().deleteAndEarn(nums));
    }
}
