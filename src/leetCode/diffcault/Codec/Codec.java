package leetCode.diffcault.Codec;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 布谷
 * @Date: 2021/6/30 10:09
 * @Description:
 */
public class Codec {

    String delimiter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return bfs(root);
    }

    public String bfs(TreeNode root){
        if(root == null){
            return null;
        }
        StringBuilder rootSb = new StringBuilder();
        rootSb.append(root.val).append(delimiter);
        rootSb.append(bfs(root.left)).append(delimiter);
        rootSb.append(bfs(root.right));

        return rootSb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArrs = data.split(delimiter);
        Integer[] dataArrIntegers = new Integer[dataArrs.length];
        for(int i = 0; i < dataArrIntegers.length; i++) {
            if("null".equals(dataArrs[i])){
                dataArrIntegers[i] = null;
            }else {
                dataArrIntegers[i] = Integer.parseInt(dataArrs[i]);
            }
        }
        TreeNode root = deserialize(dataArrIntegers,0, dataArrIntegers.length - 1);
        return root;
    }

    public TreeNode deserialize(Integer[] dataArr,int start,int end){
        if(dataArr[start] == null) {
            return null;
        }
        TreeNode root = new TreeNode(dataArr[start]);
        int leftIndex = start + 1;
        int rightIndex = leftIndex + (end - start) / 2 ;

        if(leftIndex < end){
            root.left = deserialize(dataArr,leftIndex,rightIndex - 1);
        }

        if(rightIndex < end){
            root.right = deserialize(dataArr, rightIndex, end);
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] rootArr = new Integer[]{1,2,3,null,null,4,5,};
        Codec codec = new Codec();
        TreeNode root = TreeNode.arrayToTreeNode(rootArr);
        String serialized = codec.serialize(root);
        TreeNode treeNode = codec.deserialize(serialized);
        System.out.println("serialized : " + serialized);
        System.out.println("deserialize : " + treeNode);

    }
}
