package newcoder.binarySearch;

/**
 * @Auther: 布谷
 * @Date: 2021/9/3 15:44
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,4,4,4,4,4,4,4,4,4,4};
        int target = 4;
        System.out.print(new Solution().binarySearch(nums,target));
    }

    public int binarySearch(int[] nums,int target){
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid ;
            }
        }
        if(nums[l] == target){
            return l;
        }
        return -1;
    }
}
