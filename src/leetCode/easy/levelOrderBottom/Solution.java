package leetCode.easy.levelOrderBottom;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        bfs(root,0);
        List<List<Integer>> returnArr = new ArrayList<>();
        for(int i = result.size() - 1;i>= 0 ;i--){
            returnArr.add(result.get(i));
        }
        return returnArr;
    }

    public void bfs(TreeNode root,int depth){
        if(root == null){
            return ;
        }
        if(result.size() - 1 < depth){
            List<Integer> depthList = new ArrayList<>();
            result.add(depthList);
        }
        if(result.get(depth) == null){
            List<Integer> depthList = new ArrayList<>();
            result.add(depthList);
        }
        result.get(depth).add(root.val);
        bfs(root.left,depth + 1);
        bfs(root.right,depth + 1);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        System.out.println(JSONObject.toJSONString(new Solution().levelOrderBottom(TreeNode.arrayToTreeNode(arr))));
    }
}
