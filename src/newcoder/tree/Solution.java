package newcoder.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 布谷
 * @Date: 2021/8/31 16:15
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode tree = TreeNode.arrayToTreeNode(arr);
        System.out.println(tree.toString());
        Solution solution = new Solution();
        System.out.println("先序遍历：->" + solution.preOrder(tree));
        System.out.println("后序遍历：->" + solution.sufOrder(tree));
        System.out.println("中序遍历：->" + solution.inOrder(tree));
    }


    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> pre = new Stack<>();
        pre.push(root);
        while (!pre.isEmpty()) {
            TreeNode curr = pre.pop();
            result.add(curr.val);
            if (curr.right != null) {
                pre.push(curr.right);
            }
            if (curr.left != null) {
                pre.push(curr.left);
            }
        }
        return result;
    }

    public List<Integer> sufOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> pre = new Stack<>();
        pre.push(root);
        while (!pre.isEmpty()) {
            TreeNode curr = pre.pop();
            result.add(curr.val);
            if (curr.left != null) {
                pre.push(curr.left);
            }
            if (curr.right != null) {
                pre.push(curr.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while(!stack.isEmpty() || pre != null){
            if(pre != null){
                stack.push(pre);
                pre = pre.left;
            }
            else{
                pre = stack.pop();
                result.add(pre.val);
                pre = pre.right;
            }
        }
        return result;
    }
}
