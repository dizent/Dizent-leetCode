package leetCode.easy.lowestCommonAncestor;

import java.util.Stack;

/**
 * @Auther: 布谷
 * @Date: 2021/9/13 16:46
 * @Description:
 */
public class Solution236 {

    /**
     * 分类讨论：
     * p 是 q 的祖先
     * p 是 p 的祖先
     * p 和 q 不在同一分支上
     *
     * 因为数据没有确切的规律，但是p 和q 的val不同，因此，可以直接判断数值
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isParentNode(root,p,q);
        return ans;
    }

    TreeNode ans = null;

    private Boolean isParentNode(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return false;
        }
        boolean pParent = isParentNode(root.left,p,q);
        boolean qParent = isParentNode(root.right,p,q);
        if((pParent && qParent) || ((root.val == p.val || root.val == q.val) && (pParent || qParent))){
            ans = root;
        }
        return pParent || qParent || (root.val == p.val || root.val == q.val);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        TreeNode result = new Solution236().lowestCommonAncestor(root,p,q);
        System.out.println(result);
    }
}
