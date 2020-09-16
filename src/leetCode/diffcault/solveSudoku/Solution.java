package leetCode.diffcault.solveSudoku;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {
                '6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {
                '8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {
                '7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {
                '.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Solution().solveSudoku(board);
    }

    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }


        dfs(board, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public void dfs(char[][] board, int position) {
        if (position == spaces.size()) {
            valid = true;
            return;
        }
//        int[] space = spaces.get(pos);
//        int i = space[0], j = space[1];
//        for (int digit = 0; digit < 9 && !valid; ++digit) {
//            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
//                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
//                board[i][j] = (char) (digit + '0' + 1);
//                dfs(board, pos + 1);
//                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
//            }
//        }
        int x = spaces.get(position)[0];
        int y = spaces.get(position)[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[x][digit] && !column[y][digit] && !block[x / 3][y / 3][digit]) {
                line[x][digit] = column[y][digit] = block[x / 3][y / 3][digit] = true;
                board[x][y] = (char) (digit + '0' + 1);
                dfs(board, position + 1);
                line[x][digit] = column[y][digit] = block[x / 3][y / 3][digit] = false;
            }
        }
    }

    public void solveSodoku(char[][] board, List<Integer[]> blockList, int index) {
        if (blockList.size() == index) {
            return;
        }
        int x = blockList.get(index)[0];
        int y = blockList.get(index)[1];
        //是空格,遍历填入 1 - 9
        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                board[x][y] = (char) (i + 48);
                if (isValidSudoku(board, x, y)) {
                    solveSodoku(board, blockList, index + 1);
                }
                //9个数字都不可以
                if (i == 9) {
                    //回退
                    board[x][y] = '.';
                    solveSodoku(board, blockList, index - 1);
                }
            }
        } else {
            //回退回来的，从上一个值开始遍历
            int val = board[x][y] - 48;
            for (int i = val; i <= 9; i++) {
                board[x][y] = (char) (i + 48 + 1);
                //先在原来基础上加一
                if (isValidSudoku(board, x, y)) {
                    solveSodoku(board, blockList, index + 1);
                }
                if (i == 9) {
                    //回退
                    board[x][y] = '.';
                    solveSodoku(board, blockList, index - 1);
                }
            }
        }
    }




    public boolean isValidSudoku(char[][] board, int x, int y) {
//        判断行
        if (!judgeNine(board, x, x, 0, 8)) {
            return false;
        }
        // 判断列
        if (!judgeNine(board, 0, 8, y, y)) {
            return false;
        }
        //判断3*3区块
//        for (int x = 0; x < 9; x += 3) {
//            for (int y = 0; y < 9; y += 3) {
        if (0 <= x && x <= 2) x = 0;
        if (3 <= x && x <= 5) x = 3;
        if (6 <= x && x <= 8) x = 6;
        if (0 <= y && y <= 2) y = 0;
        if (3 <= y && y <= 5) y = 3;
        if (6 <= y && y <= 8) y = 6;
        if (!judgeNine(board, x, x + 2, y, y + 2)) {
            return false;
//                }
//            }
        }
        return true;
    }

    public boolean judgeNine(char[][] board, int startX, int endX, int startY, int endY) {
        int[] liteResult = new int[9];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - 49;
                    if (index >= 9) {
                        return false;
                    }
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
}
