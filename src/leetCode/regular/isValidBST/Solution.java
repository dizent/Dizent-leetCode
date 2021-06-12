package leetCode.regular.isValidBST;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {


        List<Integer> arr= middleSearch(root);
        for(int i = 0;i< arr.size() - 1;i++){
            if(arr.get(i) > arr.get(i+1)){
                return false;
            }
        }
        boolean result =  helper(root, null, null);
        return true;
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public List middleSearch(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.addAll(middleSearch(root.left));
        result.add(root.val);
        result.addAll(middleSearch(root.right));
        return result;
    }



    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5,1,7,null,null,3,6};
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(TreeNode.arrayToTreeNode(nums)));
    }
}
