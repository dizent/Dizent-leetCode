package easy.repeatedNTimes;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 */

public class Solution {

    /**
     * 思路： 数组长度为：2 * N
     * 元素个数为 N + 1；
     * 有一个元素数量为 N
     * 则其他元素都只出现了一次，只要找到第一个出现两次的元素返回即可；
     */
    public int repeatedNTimes(int[] A) {
        int[] repeated = new int[10000];
        int i = 0;
        for(;i < A.length;i++){
            repeated [A[i]] += 1;
            if(repeated [A [i]] > 1){
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }
}
