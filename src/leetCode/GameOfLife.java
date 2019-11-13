package leetCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GameOfLife {
    public static int[][] gameOfLife(int[][] board) {
        int hight = board.length-1;
        int width = board[0].length - 1;
        for (int i = 0;i <= hight; i++){
            for(int j = 0; j <= width; j++){
                int live = getLiveNum(board,i,j);
                int target = board[i][j];
                if(live < 2){
                    target += 10;
                }
                if(live == 2){
                    target += target==1?20:10;
                }
                if(live == 3){
                    target += 20;
                }
                if(live > 3){
                    target += 10;
                }
                board[i][j] = target;
            }
        }
        for (int i = 0;i <= hight; i++){
            for(int j = 0; j <= width; j++){
                if(board[i][j] >= 20){
                    board[i][j] = 1;
                }else{
                    board [i][j] = 0;
                }
            }
        }
        return board;
    }

    public static int getLiveNum(int[][] board,int i,int j){
        int left = Math.max(j-1,0);
        int up = Math.max(i-1,0);
        int down = Math.min(i+1,board.length-1);
        int right = Math.min(j+1,board[0].length - 1);
        int liveCount = 0;
        for(int h = up; h <= down; h++){
            for(int w = left;w <= right; w++){
                if(h==i && w==j){
                    continue;
                }
                liveCount += board[h][w] % 10;
            }
        }

        return liveCount;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(gameOfLife(new int [][] {
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        })));
    }
}
