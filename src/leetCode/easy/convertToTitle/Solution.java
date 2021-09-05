package leetCode.easy.convertToTitle;

/**
 * @Auther: 布谷
 * @Date: 2021/6/29 09:27
 * @Description:
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 */
public class Solution {

    char[] titles = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public String convertToTitle(int columnNumber) {
        if(columnNumber < 1){
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int digit = 26;
        while (columnNumber > 0){
            sb.insert(0, (char)((columnNumber - 1) % digit + 'A'));
            columnNumber = (columnNumber - 1) / digit;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int columnNumber = 702;
        System.out.println(new Solution().convertToTitle(columnNumber));
    }
}
