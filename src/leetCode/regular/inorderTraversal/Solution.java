package leetCode.regular.inorderTraversal;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        inorderTraversal(root.left);
        //这一句放在不同的位置，可以变成先序、后序
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,null,2,3};
        TreeNode treeNode = TreeNode.arrayToTreeNode(arr);
        List<Integer> result;
        Solution solution = new Solution();
        result = solution.inorderTraversal(treeNode);
        System.out.println(JSONObject.toJSONString(result));
    }

}
