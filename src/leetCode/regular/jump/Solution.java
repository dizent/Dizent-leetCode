package leetCode.regular.jump;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/9/18 16:43
 * @Description:
 *
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
public class Solution {

    /**
     * 思路：
     * 动态规划：找到最近相邻的子问题
     * 1. nums[n - 1]的解 + 1
     * 2. 找到所有可以跳到 nums[n-1]的index，然后取其中最小的 + 1
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int maxPosition = 0;
        int steps = 0;
        int end = 0;
        for(int i = 0;i < nums.length - 1;i++){
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if(i == end){
                end = maxPosition;
                steps ++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}
