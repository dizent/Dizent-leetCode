package leetCode.diffcault.solveNQueens;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 */
public class Solution {

    int N;              // 记录n
    char[][] board;     // 模拟棋盘
    List<List<String>> schemes = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];
        for (char[] line : board) {     // 初始化
            Arrays.fill(line, '.');
        }
        backtrack(0);
        return schemes;
    }

    /**
     * 判断对应行哪一个位置可以放置 'Q'
     * @param row
     */
    private void backtrack(int row) {
        //已经放置完最后一行，结束循环
        if (row == board.length) {
            List<String> scheme = new LinkedList<>();
            for (char[] line : board) {
                scheme.add(String.valueOf(line));
            }
            schemes.add(scheme);
            print2ThArr(board);
            return;
        }
        //循环判断一行里面有哪些可以放置
        for (int col = 0; col < board.length; col++) {
            //判断是否合规
            if (isVaildChoess(row, col)) {
                //将对应位置放置 Q
                board[row][col] = 'Q';
                //递归下一个行
                backtrack(row + 1);
                //将改动改回，不影响一行里下一次放置（回溯，就是撤销这次选择，然后重新选择）
                board[row][col] = '.';
            }
        }
    }

    /**
     * 判断选择是不是合规
     *
     * @param row
     * @param col
     * @return
     */
    private boolean isVaildChoess(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void print2ThArr(char[][] board) {
        System.out.println("┏━━━┳━━━┳━━━┳━━━┓");
        for (int i = 0; i < board.length; i++) {
            for (char c : board[i]) {
                System.out.print("┃" + c + "\t");
            }
            System.out.println("┃");
            if (i != board.length - 1) {
                System.out.println("┣━━━╋━━━╋━━━╋━━━┫");
            }
        }
        System.out.println("┗━━━┻━━━┻━━━┻━━━┛");
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(JSONObject.toJSONString(new Solution().solveNQueens(n)));
    }
}
