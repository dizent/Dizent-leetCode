package leetCode.easy.isBalanced;


import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 */
public class Solution {

    /**
     * 思路：
     *
     * 1 先写一个计算二叉树高度的函数
     * 2 分别计算左右子树的高度
     * 3 判断左右子树的高度差是否超过 1
     * 4 如果不超过 1，则分别计算左子树以及右子树是否符合上述情况（递归）
     * 5 直到树的高度为 1 ，返回true ，停止递归；或者检测到左右子树的高度差超过 1 ，返回false，停止递归
     * 6 任意一次计算不符合上述条件，即为不平衡二叉树。
     * 7 如果子树高度为 0 ，则直接返回true
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        System.out.println(root.toString());
        System.out.println(getTreeDepth(root));
        if (root == null) {
            return true;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        if (left == 1 || right == 1) {
            return true;
        } else {
            boolean leftBalance = isBalanced(root.left);
            boolean rightBalance = isBalanced(root.right);
            if (leftBalance && rightBalance) {
                return true;
            } else {
                return false;
            }
        }
    }

    private int getTreeDepth(TreeNode treeNode) {
        int depth = 0;
        if (treeNode == null) {
            return depth;
        }
        if (treeNode.left != null && treeNode.right != null) {
            depth += 1;
            depth += Math.max(getTreeDepth(treeNode.left), getTreeDepth(treeNode.right));
        } else {
            if (treeNode.right == null) {
                depth += getTreeDepth(treeNode.left);
            }
            if (treeNode.left == null) {
                depth += getTreeDepth(treeNode.right);
            }
            depth += 1;
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] treeArray = new Integer[]{1, null, 2, null, 3};
        String treeStr = "[1, null, 2, null, 3]";
        TreeNode treeNode = processArrayToTree(treeArray, -1, false);
        TreeNode treeNode2 = stringToTreeNode(treeStr);
        System.out.println(new Solution().isBalanced(treeNode));
        System.out.println(new Solution().isBalanced(treeNode2));
    }


    /**
     * 尝试通过数组还原二叉树，但是失败了
     *
     * 下面代码并非题解，仅仅是对二叉树的还原，但是尚未完成。
     * @param treeArray
     * @param parentIndex
     * @param isLeft
     * @return
     */
    static int offset = 0;

    private static TreeNode processArrayToTree(Integer[] treeArray, int parentIndex, boolean isLeft) {
        TreeNode treeNode = null;
        int currIndex = isLeft ? 2 * parentIndex + 1  : 2 * parentIndex + 2 ;
        if (parentIndex == -1) {
            if (treeArray.length == 0) {
                return null;
            }
            treeNode = new TreeNode(treeArray[0]);
        } else {
            treeNode = treeArray[currIndex] != null ? new TreeNode(treeArray[currIndex]) : null;
        }
        if (treeNode == null) {
            offset += 2;
            return null;
        }
        if (treeArray.length > (2 * currIndex + 1 )) {
            treeNode.left = processArrayToTree(treeArray, currIndex, true);
        }
        if (treeArray.length > (2 * currIndex + 2)) {
            treeNode.right = processArrayToTree(treeArray, currIndex, false);
        }
        return treeNode;
    }

    /**
     * 官方 输入 字符串转换成 TreeNode
     *
     * 1 初始化根节点
     * 2 字符串切割成数组
     * 3 初始化链表，将根TreeNode存入第一个元素
     * 4 循环初始化 TreeNOde
     *  + 取出 链表 第一个元素
     *  + 判断循环是否已进行到数组最后一个元素
     *  + 取出数组下一个元素
     *      - 判断是否为 null 不为 null 则设置为上一个元素的left节点
     *      - 将left节点存入链表
     *  + 取出数组下一个元素
     *     - 判断是否为 null 不为 null 则设置为上一个元素的right节点
     *     - 将right节点存入链表
     * 【
     * 在后续中，可知：
     * 每次都是循环链表的第一个元素，然后设置下对应的左右子节点
     * 直到循环到数组的最后一个元素，循环结束
     * 如果后两个元素中，第一个元素为null，则对应的TreeNode 左节点为null，第二个元素为null，则右节点为null
     * 则下次循环，不会为null的TreeNode设置左右子树
     *  】
     * @param input
     * @return
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
