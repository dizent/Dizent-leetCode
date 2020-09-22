package leetCode.regular.maxArea;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且n的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int maxArea(int[] height) {
        int left = 0,right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int area;
            if(height[left] < height[right]) {
                area = (right - left) * height[left];
                left += 1;
            }else{
                area = (right - left) * height[right];
                right -= 1;
            }
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(nums));
    }
}
