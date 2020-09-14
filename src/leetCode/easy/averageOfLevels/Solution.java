package leetCode.easy.averageOfLevels;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Long> sum = new ArrayList<>();
        List<Integer> indexCount = new ArrayList<>();
        bfs(root,sum,0,indexCount);
        List<Double> result = new ArrayList<>();
        for(int i = 0;i<sum.size();i++){
            result.add( (sum.get(i) / (double)indexCount.get(i)));
        }
        return result;
    }

    private void bfs(TreeNode root, List<Long> sum, int i,List<Integer> indexCount) {
        if(root == null){
            return;
        }
        if(indexCount == null || indexCount.size() < i+1 ||indexCount.get(i) == null) indexCount.add(i,0);
        indexCount.set(i,indexCount.get(i) + 1);
        if(sum == null || sum.size() < i+1 || sum.get(i) == null) sum.add(i,0l);
        sum.set(i,sum.get(i) + root.val);
        bfs(root.left,sum,i + 1,indexCount);
        bfs(root.right,sum,i + 1,indexCount);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2147483647,2147483647,2147483647};
        TreeNode tree = TreeNode.arrayToTreeNode(arr);
        System.out.println(JSONObject.toJSONString(new Solution().averageOfLevels(tree)));
    }
}
