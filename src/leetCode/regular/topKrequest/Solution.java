package leetCode.regular.topKrequest;

import java.util.*;
import java.util.Map.Entry;

/**
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 */
public class Solution {

    /**
     * 思路与算法
     *
     * 首先遍历整个数组，并使用哈希表记录每个数字出现的次数，并形成一个「出现次数数组」。找出原数组的前 kk 个高频元素，就相当于找出「出现次数数组」的前 kk 大的值。
     *
     * 最简单的做法是给「出现次数数组」排序。但由于可能有 O(N)O(N) 个不同的出现次数（其中 NN 为原数组长度），故总的算法复杂度会达到 O(N\log N)O(NlogN)，不满足题目的要求。
     *
     * 在这里，我们可以利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：
     *
     * 如果堆的元素个数小于 kk，就可以直接插入堆中。
     * 如果堆的元素个数等于 kk，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 kk 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
     * 遍历完成后，堆中的元素就代表了「出现次数数组」中前 kk 大的值。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> kMaps = new HashMap<>();
        for (int n : nums) {
            kMaps.putIfAbsent(n, 0);
            kMaps.put(n, kMaps.get(n) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for(Entry<Integer,Integer> entry: kMaps.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }
        int[] ret = new int[k];
        for(int i = 0;i< k;i++){
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,4,1, 1, 1, 2, 2, 3,3,3,3,4};
        int k = 2;
        int[] topK = new Solution().topKFrequent(nums, k);
        for (int n : topK) {
            System.out.print(n);
        }
    }
}
