package leetCode.easy.convertBST;

import java.sql.SQLOutput;

public class Solution {

    /**
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。二叉搜索树作为一种经典的数据结构，它既有链表的快速插入与删除操作的特点，又有数组快速查找的优势；
     * 所以应用十分广泛，例如在文件系统和数据库系统一般会采用这种数据结构进行高效率的排序与检索操作。
     */

    int sum  = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }




    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = TreeNode.arrayToTreeNode(arr);
        System.out.println(root);
        System.out.println(new Solution().convertBST(root).toString());
    }
}
