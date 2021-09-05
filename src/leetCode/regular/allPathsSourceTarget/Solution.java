package leetCode.regular.allPathsSourceTarget;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Auther: 布谷
 * @Date: 2021/8/25 09:27
 * @Description:
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        stack.offerLast(0);
        dfs(graph,0, graph.length - 1);

        return ans;
    }

    public void dfs(int[][] graph, int source, int target) {
       if(source == target){
           ans.add(new ArrayList<>(stack));
           return ;
       }
       for(int x : graph[source]){
           stack.offerLast(x);
           dfs(graph, x, target);
           stack.pollLast();
       }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> result = new Solution().allPathsSourceTarget(graph);
        System.out.println(JSONObject.toJSONString(result));
    }
}
