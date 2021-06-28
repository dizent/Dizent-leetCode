package leetCode.regular.rotateGrid;

import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: 布谷
 * @Date: 2021/6/27 10:51
 * @Description: 只跑过了一个测试用例，还要完善
 */
public class Solution {

    /**
     * 规律：
     * 层数：一共有Math.min(m,n) / 2 层
     * 第一层元素数：2 * (n + m - 1 - 1)
     * 第二层元素数： 2 * (n + m - 2 - 1 - 2 - 1 )
     * 加上index元素 转换 -> 第 i 层元素数： 2 * (m+n - 2 * i  - 2 * (i - 1))
     * 当k能整除当前层元素数的时候，那么代表本层不需要移动
     * @param grid
     * @param k
     * @return
     */
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int floors = Math.min(m, n) / 2;
        for (int f = 0; f <= floors; f++) {
            int nodeNum = 2 * (m + n - 4 * (f + 1) + 2);
            if (k % nodeNum == 0) {
                continue;
            } else {
                int lift = k % nodeNum;
                for (int i = 0; i < lift; i++) {
                    //得出当前层的元素组，再进行移动
                    int flag = 0;
                    int head = grid[f][f];
                    int column = f;
                    int row = f;
                    for (int step = 0; step < nodeNum; step++) {
                        switch (flag) {
                            case 0:
                                grid[row][column] = grid[row][column + 1];
                                if (column == n - f - 2) {
                                    flag = 1;
                                }
                                column++;
                                break;
                            case 1:
                                grid[row][column] = grid[row + 1][column];
                                if (row == m - f - 2) {
                                    flag = 2;
                                }
                                row++;
                                break;
                            case 2:
                                grid[row][column] = grid[row][column - 1];
                                if (column == f + 1) {
                                    flag = 3;
                                }
                                column--;
                                break;
                            case 3:
                                if (row - 1 == f && column == f) {
                                    grid[row][column] = head;
                                } else {
                                    grid[row][column] = grid[row - 1][column];
                                }
                                if (row == f + 1) {
                                    flag = 0;
                                }
                                row--;
                                break;
                        }
                    }
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int [][]grid = new int[][]{{10,1,4,8},{6,6,3,10},{7,4,7,10},{1,10,6,1},{2,1,1,10},{3,8,9,2},{7,1,10,10},{7,1,4,9},{2,2,4,2},{10,7,5,10}};
        int k = 1;
        int[][] rotateGrip = new Solution().rotateGrid(grid,k);
        System.out.println(JSONObject.toJSONString(rotateGrip));
    }
}
