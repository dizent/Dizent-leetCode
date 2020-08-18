package leetCode.easy.isBalanced;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" +
                "\"val\":" + val +
                ", \"left\":" + left +
                ", \"right\":" + right +
                '}';
    }
}
