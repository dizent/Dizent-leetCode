package leetCode.regular.largestNumber;

/**
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 */

public class Solution {


    public String largestNumber(int[] nums) {


        for(int i = 0 ;i < nums.length - 1; i++){
            for(int j = i + 1;j <nums.length;j++){
                if(compareAB(nums[i],nums[j])){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return null;
    }

    /**
     * 如果A < B 则调换位置
     * @param A
     * @param B
     * @return
     */
    private boolean compareAB(int A, int B) {
        if(A < 10 && B < 10 ){
            return A < B;
        }
        int index = 0;
        while(true){
            int indexA = A / 10;
            int indexB = B / 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3,30,34,5,9}));
    }
}
