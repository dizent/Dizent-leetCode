package leetCode.regular.exist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        boolean[][] choosed = new boolean[board.length][board[0].length];
        List<Integer[]> first = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    first.add(new Integer[]{i, j});
                }
            }
        }
        for (Integer[] f : first) {
            if (bfs(board, choosed, f[0], f[1], word)) {
                return true;
            }
        }
        return false;
    }

    public boolean bfs(char[][] board, boolean[][] choosed, int x, int y, String word) {
        if( x < 0 || y < 0 || x >= board.length || y >= board[x].length){
            return false;
        }
        if (board[x][y] == word.charAt(0) && !choosed[x][y]) {
            if (word.length() == 1) {
                return true;
            }
            choosed[x][y] = true;
            if (bfs(board, choosed, x - 1, y, word.substring(1)) ||
                    bfs(board, choosed, x, y - 1, word.substring(1)) ||
                    bfs(board, choosed, x + 1, y, word.substring(1)) ||
                    bfs(board, choosed, x, y + 1, word.substring(1))) {
                return true;
            }
            choosed[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "ABCB";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));

    }
}
