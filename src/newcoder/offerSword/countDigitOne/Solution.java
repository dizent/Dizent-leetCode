package newcoder.offerSword.countDigitOne;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <2^31
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 思路:
     * <p>
     * 对10的幂进行计算：
     * <p>
     * 0-9为10的0次幂：0-9的个数为 1 * 10^0 + 9 * 0 = 1 为 l
     * <p>
     * 10-99为10^1： 10-99的个数为： 1 * 10^1 + 9 * l = 19;则0-99为 19 + l = 20  为 m
     * <p>
     * 100-999为10^2： 10-99的个数为： 1 * 10^2 + 9 * m = 280;则0-999为 100 + 180 +  m = 300 为 n
     * <p>
     * 1000-9999为10^3:1000-9999: 1 * 10^3 + 90 * n = 1270;ze 0-9999为 1270 + n = 1570
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;

    }

    public static void main(String[] args) {
        int n = 2324;
        System.out.println(new Solution().countDigitOne(n));
    }
}
