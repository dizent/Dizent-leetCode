package leetCode.easy.isPowerTwo;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20= 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24= 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        if(n < 1){
            return false;
        }
        int result = n & n-1;
        return result == 0;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().isPowerOfTwo(n));
    }


}