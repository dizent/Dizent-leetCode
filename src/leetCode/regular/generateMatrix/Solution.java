package leetCode.regular.generateMatrix;


//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = n * n;
        int i = 0;
        int j = 0;
        int q = 0;
        //当前方向
        int path = 0;
        for (int member = 1; member <= num; member++){
            result[i][j] = member;
            switch (path){
                case 0:
                    j += 1;
                    if(j == n - q - 1){
                        path = 1;
                    }
                    break;
                case 1:
                    i += 1;
                    if(i == n - q - 1){
                        path = 2;
                    }
                    break;
                case 2:
                    j -= 1;
                    if(j == 0 + q){
                        path = 3;
                        q += 1;
                    }
                    break;
                case 3:
                    i -= 1;
                    if(i == 0 + q){
                        path = 0;
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().generateMatrix(3);
    }
}
