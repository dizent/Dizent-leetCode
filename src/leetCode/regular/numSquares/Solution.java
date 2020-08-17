package leetCode.regular.numSquares;


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

    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        boolean flag = false;
        for(int i = 2; !flag ;i++){
            Integer multi = i * i ;
            if(multi > n){
                flag = true;
                int num = n - (i - 1) * (i - 1);
                return numSquares(num) + 1;
            }
            if(multi == n){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer num = 100;
        System.out.println(new Solution().numSquares(13));
    }
}
