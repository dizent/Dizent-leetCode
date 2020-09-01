package leetCode.regular.isValidSudoku;

/**
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * 示例1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例2:
 *
 * 输入:
 * [
 *  ["8","3",".",".","7",".",".",".","."],
 *  ["6",".",".","1","9","5",".",".","."],
 *  [".","9","8",".",".",".",".","6","."],
 *  ["8",".",".",".","6",".",".",".","3"],
 *  ["4",".",".","8",".","3",".",".","1"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".","6",".",".",".",".","2","8","."],
 *  [".",".",".","4","1","9",".",".","5"],
 *  [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字1-9和字符'.'。
 * 给定数独永远是9x9形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 思路：
     *
     * 将数独的各个行，列，3*3区块分别判断有没有重复的数字
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
//        判断行
        for (int x = 0; x < 9; x++) {
            if (!judgeNine(board, x, x, 0, 8)) {
                return false;
            }
        }
        // 判断列
        for (int y = 0; y < 9; y++) {
            if (!judgeNine(board, 0, 8, y, y)) {
                return false;
            }
        }
        //判断3*3区块
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                if (!judgeNine(board, x, x+2, y, y + 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断九个元素之间有没有重复的数字
     * @param board
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @return
     */
    public boolean judgeNine(char[][] board, int startX, int endX, int startY, int endY) {
        int[] liteResult = new int[9];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - 49;
                    liteResult[index] += 1;
                }
            }
        }

        for (int i = 0; i < liteResult.length; i++) {
            if (liteResult[i] > 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'},
        };

        System.out.println(new Solution().isValidSudoku(board));
    }
}
