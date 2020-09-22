package other;

/**
 * 爬楼梯，爬n层楼梯，一次可以爬1 或者 2 层，求有多少种爬法
 */
public class TimeOfgetWater {

    /**
     * 台阶为1 ，解法为 1
     * 2 ：2
     * 3 : 1 + 2 = 3
     * 4 : 2 + 3 = 5
     *
     * n : ans[n-1] + ans[n-2]
     *
     * 用数组记录上一个解，避免多次重复递归
     *
     * 此题类似于求"斐波那契数列"
     * @param n
     * @return
     */
    public int getWater(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 45;
        TimeOfgetWater timeOfgetWater = new TimeOfgetWater();
        System.out.println(timeOfgetWater.getWater(n));
    }
}
