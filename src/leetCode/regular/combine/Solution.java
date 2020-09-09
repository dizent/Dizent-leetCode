package leetCode.regular.combine;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入:n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        if (k > n) {
            return result;
        }
        combine(new ArrayList<>(), nums, k);
        return result;
    }

    /**
     * 回溯算法，思路：
     *
     * 递归结束条件：当只选择一个数字时，将备选数字所有情况进行循环保存
     *
     * + 选择备选数字中的元素，然后将备选数字集合去除，将 k - 1
     * + 递归
     * + 当前选择递归完成之后，将pre去除当前选择，避免影响后续选择
     *
     * @param pre
     * @param nums
     * @param k
     */
    public void combine(List<Integer> pre, List<Integer> nums, int k) {
        if (k == 1) {
            for (int i = 0; i < nums.size(); i++) {
                pre.add(nums.get(i));
                result.add(new ArrayList<>(pre));
                pre.remove(pre.size() - 1);
            }
            return;
        }
        for (int i = 0;i < nums.size() ; i++) {
            pre.add(nums.get(i));
            combine(pre, nums.subList(i + 1, nums.size()), k - 1);
            pre.remove(pre.size() - 1);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        System.out.println(JSONObject.toJSONString(new Solution().combine(n, k)));
    }

}
