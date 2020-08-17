package leetCode.easy.countBinarySubstrings;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 */
public class Solution {

    public int countBinarySubstrings(String s) {
        char[] sChar = s.toCharArray();
        List<Integer> sCharList = new ArrayList<>();
        char preChar = 2;
        int countChar = 0;
        for (char c : sChar) {
            if (countChar == 0) {
                preChar = c;
                countChar++;
            } else {
                if (c == preChar) {
                    countChar++;
                } else {
                    sCharList.add(countChar);
                    preChar = c;
                    countChar = 1;
                }
            }
        }
        sCharList.add(countChar);
        System.out.println(JSONObject.toJSONString(sCharList));
        int countResult = 0;
        for (int i = 0; i < sCharList.size() - 1; i++) {
            countResult += sCharList.get(i) > sCharList.get(i + 1) ? sCharList.get(i + 1) : sCharList.get(i);
        }
        return countResult;
    }

    public static void main(String[] args) {
        String str = "00100";
        System.out.println(new Solution().countBinarySubstrings(str));
    }
}
