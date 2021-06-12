package leetCode.regular.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 使用滑动窗口算法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int strLen = s.length();
        int subStrLen = 0;
        //存储字符的位置map
        Map<Character, Integer> characterIndexMap = new HashMap<>();
        for(int end = 0,start = 0;end < strLen; end ++){
            Character alpha = s.charAt(end);
            if(characterIndexMap.containsKey(alpha)){
                start = Math.max(characterIndexMap.get(alpha),start);
            }
            subStrLen = Math.max(subStrLen , end - start +1);
            characterIndexMap.put(s.charAt(end),end + 1);
        }
        return subStrLen;
    }

    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }
}
