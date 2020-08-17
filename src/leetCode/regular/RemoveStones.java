package leetCode.regular;
import	java.awt.Point;
import	java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class RemoveStones {
    public static int function(int[][] stones){
        List<Point> points = new ArrayList<Point> ();
        for(int i = 0;i<stones.length; i++){
            points.add(new Point(stones[i][0],stones[i][1]));
        }
        points.sort((o1, o2) -> {
            if(o1.x < o2.x){
                return 1;
            }
            return 0;
        });
        List<Point> lineP = new ArrayList<>();
        for(int i = points.size()-1;i>=0;i--){
            if(lineP.isEmpty()) {
                lineP.add(points.get(i));
            }else{
                int lineSize = lineP.size();
                for(int j = 0;j<lineSize;j++){
                    if(lineP.contains(points.get(i))){
                        continue;
                    }
                    if(lineP.get(j).x == points.get(i).x || lineP.get(j).y == points.get(i).y){
                        lineP.add(points.get(i));
                        continue;
                    }
                }
            }
        }
        return lineP.size() -1;
    }

    static class Point implements Comparator<Point> {
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.x < o2.x){
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(function(new int[][]{{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}}));
    }
}
