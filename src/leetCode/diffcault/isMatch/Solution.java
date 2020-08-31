package leetCode.diffcault.isMatch;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 思路：
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            if (s == null || s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (p.charAt(0) == '.') {
            if (p.charAt(1) != '*') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                //如果是 '.*' 则表示，可以匹配任意字符的'.'出现了无数次，所以可以匹配所有字符。因此，要找到下下个字符来匹配
                if(p.length() == 2){
                    return true;
                }
                char suf = p.charAt(2);
                int nextIndex = 0;
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) == suf) {
                        nextIndex = i;
                        break;
                    }
                }
                if (nextIndex == 0) {
                    if (p.length() == 2) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return isMatch(s.substring(nextIndex), p.substring(2));
            }
        }
        if (p.charAt(0) == '*') {
            return false;
        }
        if (p.charAt(0) == s.charAt(0)) {
            if (p.length() == 1) {
                if (s.length() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            if (p.charAt(1) != '*') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                char pre = s.charAt(0);
                int nextIndex = 0;
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) != pre) {
                        nextIndex = i;
                        break;
                    }
                }
                if (nextIndex == 0) {
                    if (p.length() == 2) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return isMatch(s.substring(nextIndex), p.substring(2));
            }
        }
        if (p.charAt(0) != s.charAt(0)) {
            if (p.length() == 1) {
                if (s.length() == 1) {
                    return false;
                }
            }
            if (p.charAt(1) != '*') {
                return false;
            } else {
                return isMatch(s, p.substring(2));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "";
        String p = "a*";
        System.out.println(new Solution().isMatch(s, p));
    }
}
