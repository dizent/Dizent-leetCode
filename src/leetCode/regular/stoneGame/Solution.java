package leetCode.regular.stoneGame;

import java.util.Arrays;

public class Solution {

    public boolean stoneGame(int[] piles) {
        int m = piles.length;
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfs(piles, 0, m - 1, dp) >= 0;
    }

    private int dfs(int[] piles, int left, int right, int[][] dp) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != Integer.MIN_VALUE) {
            return dp[left][right];
        }
        int ifLeft = piles[left] - dfs(piles, left + 1, right, dp);
        int ifRight = piles[right] - dfs(piles, left, right - 1, dp);
        dp[left][right] = Math.max(ifLeft, ifRight);
        return dp[left][right];
    }


    public static void main(String[] args) {
        int[] piles = new int[]{3,5,10,4};
        System.out.println(new Solution().stoneGame(piles));
    }
}
