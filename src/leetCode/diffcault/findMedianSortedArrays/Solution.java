package leetCode.diffcault.findMedianSortedArrays;


/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组"nums1 和"nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为"O(log(m + n))。
 *
 * 你可以假设"nums1"和"nums2"不会同时为空。
 *
 * "
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class Solution {

    /**
     * 使用二分查找法（时间复杂度为O(log(n))）
     * 将长度较短的数组A（长度 m ），作为基数数组，拿到中间的元素 位置为 i，
     * 长度较长的数组B（长度 n ），作为查找数组，
     * 判断 第二个数组的对应元素（m+n+1）/2 - i = j
     * 判断两个元素的大小情况：
     *  + A[i] >= B[j-1] && A[i-1] <= B[i] 说明正好是这一组
     *  + A[i] < B[j-1] 说明 i 偏小，应该向右移动
     *  + A[i-1] > B[j] 说明 i 偏大，应该向左移动
     *
     * 存在特殊情况：当一个数组的所有元素都比另一个数组的所有元素小
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        //奇数
        if((length & 1) == 1){
            int index = (length - 1) >> 1;
            return topInteger(nums1,nums2,index);
        }else{
            int r = length >> 1;
            return topInteger(nums1,nums2,r);
        }
    }

    private double topInteger(int[] nums1, int[] nums2, int index) {
        int lsize = nums1.length;
        int rsize = nums2.length;
        int[] mergeArr = new int[lsize + rsize];
        if(lsize == 0){
            mergeArr = nums2;
        }
        if(rsize == 0){
            mergeArr = nums1;
        }
        int lIndex = 0;
        int rIndex = 0;
        for(int i = 0;i <= index;i++){
            if(lIndex > lsize - 1){
                mergeArr[i] = nums2[rIndex];
                rIndex ++;
                continue;
            }
            if(rIndex > rsize - 1){
                mergeArr[i] = nums1[lIndex];
                lIndex ++;
                continue;
            }
            mergeArr[i] = Math.min(nums1[lIndex] ,nums2[rIndex]);
            if(nums1[lIndex] < nums2[rIndex]){
                lIndex++;
            }else{
                rIndex++;
            }
        }
        if((lsize + rsize) % 2 == 0) {
            return (double)(mergeArr[index] + mergeArr[index - 1]) / 2;
        }else{
            return mergeArr[index];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }
}
