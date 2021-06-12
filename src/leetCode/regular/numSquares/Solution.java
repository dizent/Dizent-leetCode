package leetCode.regular.numSquares;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class Solution {

    /**
     * 动态规划：
     * 1. 计算出1-100的平方数组
     * 2. 从大到小取数字
     * 3. 当数字命中平方数组时，返回1
     * 4. 当值未命中，则往后面找
     * @param n
     * @return
     */
    public int numSquare2s(int n) {
        int[] dp = new  int[n+1];
        for(int i = 1;i <= n;i++){
            dp[i] = i ;
            for(int j = 1;i - j * j >= 0;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
//
//        int[] dp = new int[n + 1]; // 默认初始化值都为0
//        for (int i = 1; i <= n; i++) {
//            dp[i] = i; // 最坏的情况就是每次+1
//            for (int j = 1; i - j * j >= 0; j++) {
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
//            }
//        }
//        return dp[n];
    }


























    public int numSquares(int n){
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n ;i ++){
            dp[i] = i;
            for(int j = 1;i - j * j >= 0;j++){
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Integer num = 13;
        System.out.println(new Solution().numSquares(num));
    }
}
