package leetCode.easy.minDepth;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 */
public class Solution {

    /**
     * 思路：
     *
     * 1 利用深度优先算法，遍历左右子树最大深度(找到子树上没有叶子节点的那个深度)
     * 2 如果有一方深度为 0 ，则加上 另一方的深度
     * 3 如果都不为 0 ，则加上深度较小的值
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return bfs(root);
    }

    public int bfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 1;
        if(root.left == null && root.right == null){
            return depth;
        }
        int left = bfs(root.left);
        int right = bfs(root.right);
        if(left == 0 || right == 0) {
            depth += left == 0 ? right : left;
        }else{
            depth += Math.min(left, right);
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] params = new Integer[]{1,2,3,4,5};
        TreeNode root = TreeNode.arrayToTreeNode(params);
        System.out.println(root.toString());
        System.out.println(new Solution().minDepth(root));
    }
}
