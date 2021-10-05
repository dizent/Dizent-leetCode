package leetCode.regular.findpeekElement;

/**
 * @Auther: 布谷
 * @Date: 2021/9/15 22:49
 * @Description:
 */
public class Solution {

    public int findPeekElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid + 1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().findPeekElement(nums));
    }
}
