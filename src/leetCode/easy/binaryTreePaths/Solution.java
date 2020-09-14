package leetCode.easy.binaryTreePaths;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    StringBuffer route = new StringBuffer();
    List<String> result = new ArrayList<>();

    boolean lastLeaf = false;

    int lastLeafLength = 0;

    public List<String> binaryTreePaths(TreeNode root) {
        dfsWithOutBackTracking(root,new StringBuffer(""));
        return result;
    }

    /**
     * 无回溯的深度优先遍历
     */
    public void dfsWithOutBackTracking(TreeNode root,StringBuffer path){
        if(root != null){
            StringBuffer pathSb = new StringBuffer(path);
            pathSb.append(root.val);
            if(root.left == null && root.right == null){
                result.add(pathSb.toString());
            }else{
                pathSb.append("->");
                dfsWithOutBackTracking(root.left,pathSb);
                dfsWithOutBackTracking(root.right,pathSb);
            }

        }
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        //区分两种情况，一个是从根节点返回过来的，一个是从叶子节点返回过来的，根节点只新增了一个元素，所以删除1，叶子节点新增三个元素，所以删除3；
        if (root.left == null && root.right == null) {
            route.append(root.val);
            result.add(route.toString());
            lastLeafLength = String.valueOf(root.val).length();
            lastLeaf = true;
            return;
        } else {
            route.append(root.val + "->");
            if (root.left != null) {
                dfs(root.left);
                int valLength = String.valueOf(root.left.val).length();
                if (lastLeaf) {
                    route.delete(route.length() - lastLeafLength, route.length());
                } else {
                    route.delete(route.length() - 2 - valLength, route.length());
                }
                lastLeafLength = 0;
                lastLeaf = false;
            }
            if (root.right != null) {
                dfs(root.right);
                int valLength = String.valueOf(root.right.val).length();
                if (lastLeaf) {
                    route.delete(route.length()  - lastLeafLength, route.length());
                } else {
                    route.delete(route.length() - 2 - valLength, route.length());
                }
                lastLeafLength = 0;
                lastLeaf = false;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8};
        TreeNode root = TreeNode.arrayToTreeNode(arr);
        System.out.println(JSONObject.toJSONString(new Solution().binaryTreePaths(root)));
    }
}
