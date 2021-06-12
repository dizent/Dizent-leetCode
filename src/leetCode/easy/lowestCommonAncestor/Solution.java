package leetCode.easy.lowestCommonAncestor;

public class Solution {


    /**
     * 因为给定的是一个二叉搜索树
     *
     * 判断 p 和 q 的数值，与 root 比较，如果
     *  - 都比 root 大，则往右判断
     *  - 都比 root 小，则往左判断
     *  - root 介于中间，则为 root
     *  - 如果 root 值等于其中一个，则返回当前 root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minVal = Math.min(p.val,q.val);
        int maxVal = Math.max(p.val,q.val);
        TreeNode occu = root;
        while(true) {
            if (occu.val > maxVal) {
                occu = occu.left;
            } else if(occu.val < minVal){
                occu = occu.right;
            }else{
                break;
            }
        }
        return occu;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        TreeNode result = new Solution().lowestCommonAncestor(root,p,q);
        System.out.println(result);
    }
}
