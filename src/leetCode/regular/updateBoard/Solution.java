package leetCode.regular.updateBoard;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。'M'代表一个未挖出的地雷，'E'代表一个未挖出的空方块，'B'代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X'则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Click : [1,2]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 */
public class Solution {

    /**
     * 思路：
     * <p>
     * 1 根据题意理解为：给出一个扫雷面板，一个点击位置，根据题目的规则，给出点击之后的扫雷面板
     * 2 广度优先遍历面板，先判断点击的那个点的周围八个点有多少M
     *  + 如果无M，则改为B，然后将其列入下次判断
     *  + 如果有M，计数，不递归
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoardupdateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        if (board[x][y] == 'E') {
            return transEmptyBoard(board, x, y);
        }
        return board;
    }

    private char[][] transEmptyBoard(char[][] board, int x, int y) {
        char countClick = '0';
        Integer[][] nextArr = new Integer[8][2];
        int index = 0;
        if (x > 0) {
            if (isM(board[x - 1][y])) {
                countClick++;
            }
            if (isE(board[x - 1][y])) {
                nextArr[index++] = new Integer[]{x-1,y};
            }
            if (y > 0) {
                if (isM(board[x - 1][y - 1])) {
                    countClick++;
                }if (isE(board[x - 1][y - 1])) {
                    nextArr[index++] = new Integer[]{x-1,y-1};

                }
            }
            if (y < board[x].length - 1) {
                if (isM(board[x - 1][y + 1])) {
                    countClick++;
                }if (isE(board[x - 1][y + 1])) {
                    nextArr[index++] = new Integer[]{x-1,y+1};

                }
            }
        }
        if (x < board.length - 1) {
            if (isM(board[x + 1][y])) {
                countClick++;
            }if (isE(board[x + 1][y])) {
                nextArr[index++] = new Integer[]{x+1,y};

            }
            if (y > 0) {
                if (isM(board[x + 1][y - 1])) {
                    countClick++;
                }if (isE(board[x + 1][y - 1])) {
                    nextArr[index++] = new Integer[]{x+1,y-1};

                }
            }
            if (y < board[x].length - 1) {
                if (isM(board[x + 1][y + 1])) {
                    countClick++;
                }if (isE(board[x + 1][y + 1])) {
                    nextArr[index++] = new Integer[]{x+1,y+1};

                }
            }
        }
        if (y > 0) {
            if (isM(board[x][y - 1])) {
                countClick++;
            }if (isE(board[x][y - 1])) {
                nextArr[index++] = new Integer[]{x,y-1};

            }
        }
        if (y < board[x].length - 1) {
            if (isM(board[x][y + 1])) {
                countClick++;
            }if (isE(board[x][y + 1])) {
                nextArr[index++] = new Integer[]{x,y+1};

            }
        }
        if (countClick == '0') {
            board[x][y] = 'B';
            //周围无雷，需要判断周围八个点,判断时，排除当前点。
            for(int i = 0;i < nextArr.length;i++){
                if(nextArr[i][0] != null) {
                    transEmptyBoard(board, nextArr[i][0], nextArr[i][1]);
                }
            }
        } else {
            //周围有雷，修改为数字，不进行递归判断
            board[x][y] = countClick;
        }
        return board;
    }

    private boolean isM(char c) {
        return 'M' == c;
    }
    private boolean isE(char c) {
        return 'E' == c;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'M', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'},
        };
        int[] click = new int[]{3, 0};
        System.out.println(JSONObject.toJSONString(new Solution().updateBoardupdateBoard(board, click)));
    }
}
