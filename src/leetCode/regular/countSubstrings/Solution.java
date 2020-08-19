package leetCode.regular.countSubstrings;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 */
public class Solution {

    /**
     * 思路，枚举可能性，然后计算数量
     *
     * 1 从第一个字符 str[0] 开始，首先判断中心字符为 一个字符的情况，判断有多少以 str[0] 为中心的回文串
     * 2 再判断 中心字符为 两个字符的情况，判断有多少以 str[0] str[1] 为中心的回文串
     * 3 将判断的位置逐个后移，遍历整个字符串
     *
     * 此题看了题解，只是将字符串判断改为char[] 处理
     */
    int num = 0;
    public int countSubstrings(String s) {
        char[] strArr = s.toCharArray();
        for (int i=0; i < strArr.length; i++){
            count(strArr, i, i);//回文串长度为奇数
            count(strArr, i, i+1);//回文串长度为偶数
        }
        return num;
    }

    public void count(char[] s, int start, int end){
        while(start >= 0 && end < s.length && s[start] == s[end]){
            num++;
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(new Solution().countSubstrings(str));
    }
}
