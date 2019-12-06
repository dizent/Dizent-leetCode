package diffcault.rectangleArea;

import com.alibaba.fastjson.JSONObject;

public class Solution {

    int MAX_LENGTH = 100000;

    public int rectangleArea(int[][] rectangle){
        int tree[][] = new int[MAX_LENGTH][4];
        buildTree(rectangle,tree,0,0,rectangle.length);

        return 0;
    }

    public void buildTree(int[][] rectangle,int[][] tree,int node,int start,int end){
        int mid = rectangle.length / 2;
        int left = 2 * mid + 1;
        int right = 2 * mid + 2;
        buildTree(rectangle,tree,left,start,mid);
        buildTree(rectangle, tree, right, mid + 1, end);
    }


    public static void main(String[] args) {
        String input = "{{0,0,2,2},[1,0,2,3],[1,0,3,1]]";
        System.out.println( new Solution().rectangleArea(new int[][]{}));
    }
}
