package leetCode.regular.findKthLargest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 思路：
     *
     * 新建一个队列，根据数字大小排序
     *
     * + 循环遍历数组
     * + 当数组元素少于k时，直接add
     * + 当元素个数大于k时，判断队列顶部元素（队列排序，顶部为最小元素）是否大于当前元素
     * + 如果当前元素更大，则将队列顶部元素移除
     * + 将当前元素add到队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null ||nums.length == 0){
            return 0;
        }
        PriorityQueue<Integer> kThLargest = new PriorityQueue<Integer>(Comparator.comparingInt(o -> o));
        for(int i = 0;i<nums.length;i++){
            if(kThLargest.size() < k){
                kThLargest.add(nums[i]);
            }else{
                if(kThLargest.peek() < nums[i]){
                    kThLargest.remove();
                    kThLargest.add(nums[i]);
                }
            }
        }
        return kThLargest.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,5,5,6};
        int k = 4;
        System.out.println(new Solution().findKthLargest(nums,k));
    }
}
