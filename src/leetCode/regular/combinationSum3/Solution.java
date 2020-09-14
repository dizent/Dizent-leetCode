package leetCode.regular.combinationSum3;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> init = new ArrayList<>();
        for(int i = 0;i < 9;i++){
            init.add(i+1);
        }
        dfs(new ArrayList<>(),0,init,k,n);
        return result;
    }

    void dfs(List<Integer> preSelect,Integer preSum,List<Integer> nums,int k,int n){
        if(preSum > n){
            return;
        }
        if(preSelect.size() == k && preSum != n){
            return;
        }
        if(preSum == n && preSelect.size() == k){
            result.add(new ArrayList<>(preSelect));
        }
        for(int i = 0;i<nums.size();i++){
            preSelect.add(nums.get(i));
            preSum += nums.get(i);
            dfs(preSelect,preSum,nums.subList(i+1,nums.size()),k,n);
            preSelect.remove(preSelect.size() - 1);
            preSum -= nums.get(i);
        }
    }

    /**
     * 找出k个数，相加等于n，所有组合
     * @param args
     */
    public static void main(String[] args) {
        int k = 2;
        int n = 18;
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.combinationSum3(k,n)));
    }


}
