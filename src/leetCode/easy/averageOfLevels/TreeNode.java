package leetCode.easy.averageOfLevels;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

     int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" +
                "\"val\":" + val +
                ", \"left\":" + left +
                ", \"right\":" + right +
                '}';
    }

    public static TreeNode arrayToTreeNode(Integer[] parts) {
        Integer item = parts[0];
        TreeNode root = new TreeNode(item);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            if (item != null) {
                int leftNumber = item;
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            if (item != null) {
                int rightNumber = item;
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
