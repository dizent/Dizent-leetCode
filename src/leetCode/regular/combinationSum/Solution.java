package leetCode.regular.combinationSum;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(new ArrayList<>(), 0, candidates, target);
        return result;
    }

    /**
     * @param pre       已经选择的
     * @param preSum    已经选择数字的和
     * @param candidate 待选择的数字
     * @param target    目标和
     */
    public void dfs(List<Integer> pre, Integer preSum, int[] candidate, Integer target) {
        if (preSum.intValue() == target.intValue()) {
            result.add(new ArrayList<>(pre));
            return;
        }
        if (preSum > target) {
            return;
        }
        for (int i = 0; i < candidate.length; i++) {
            pre.add(candidate[i]);
            preSum += candidate[i];
            dfs(pre, preSum, Arrays.copyOfRange(candidate,i,candidate.length), target);
            pre.remove(pre.size() - 1);
            preSum -= candidate[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6,7};
        int target = 7;
        Solution sol = new Solution();
        System.out.println(JSONObject.toJSONString(sol.combinationSum(candidates, target)));
    }
}
