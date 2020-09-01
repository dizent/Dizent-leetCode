package leetCode.easy.longestCommonPrefix;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 纵向比较，比较每一个字符串的前缀，是否相同，一个一个字符向后排查，查到不相同的，则返回
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuffer stringBuffer = new StringBuffer("");
        if(strs.length == 0){
            return "";
        }
        if(strs[0].length() == 0){
            return "";
        }
        boolean flag = true;
        for(int i = 0;i < strs[0].length();i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.isEmpty()) {
                    flag = false;
                    break;
                }
                if(str.length() <= i){
                    flag = false;
                    break;
                }
                if (c != str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                stringBuffer.append(c);
            }else{
                break;
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"aa","a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
