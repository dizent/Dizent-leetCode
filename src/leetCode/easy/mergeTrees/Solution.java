package leetCode.easy.mergeTrees;

public class Solution {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.right = mergeTrees(t1.right,t2.right);
        t1.left = mergeTrees(t1.left,t2.left);
        return t1;
    }

    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{1,3,2,5};
        Integer[] nums2 = new Integer[]{2,1,3,null,4,null,7};
        System.out.println(new Solution().mergeTrees(TreeNode.arrayToTreeNode(nums1),TreeNode.arrayToTreeNode(nums2)));
    }
}
