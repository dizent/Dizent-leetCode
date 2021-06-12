package leetCode.regular.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows =4
 * 输出:"LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 整理：
     *
     * 我们可以使用 {min}({numRows}, {len}(s))min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
     *
     * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     *
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public void print2ThArr(char[][] board) {
        System.out.println("┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓");
        for (int i = 0; i < board.length; i++) {
            for (char c : board[i]) {
                System.out.print("┃" + c + "\t");
            }
            System.out.println("┃");
            if (i != board.length - 1) {
                System.out.println("┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫");
            }
        }
        System.out.println("┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛");
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 5;
        System.out.println(new Solution().convert(s,numRows));

    }
}
