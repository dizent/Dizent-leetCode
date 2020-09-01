package nowcoder.offerSword.sumNums;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出:6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出:45
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 思路：
     *
     * 去除题目不让用的关键字以及语句
     *
     * 逻辑 && 以及 || 判断 总结：
     *  当 A && B 判断，A为 false 时 ，B 不执行
     *  当 A || B 判断，A为 true 时，B 不执行
     * 因此，将 && 来作为递归结束的判断
     * 其余思路正常使用递归。
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = n  > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(new Solution().sumNums(n));
    }
}
