package leetCode.regular;


import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

    class Point{
        int x;
        int y;

        public Point(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }


    public void maxDist(){
        System.out.println(maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }

    public int maxDistance(int[][] grid) {
        List<Point> q = new ArrayList<Point>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid [0].length; j++) {
                if(grid [i] [j] == 1){
                    q.add(new Point(i,j));
                }
            }
        }
        if(q.size() == 0 || q.size() == grid.length*grid [0].length){
            return -1;
        }
        int m = grid.length;
        int n = grid [0].length;
        int landCount = q.size();
        int mapCount = m * n;
        int seaCount = mapCount - landCount;
        return getMaxDistance(grid,q,seaCount,0);
    }

    private int getMaxDistance(int[][] grid, List<Point> q,int seaCount,int ret) {
        int m = grid.length;
        int n = grid [0].length;
        List<Point> addLand = new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            Point p = q.get(i);
            if (p.x - 1 >= 0) {
                if (grid[p.x - 1][p.y] != 1) {
                    seaCount--;
                    grid[p.x - 1][p.y] = 1;
                    addLand.add(new Point(p.x - 1, p.y));
                }
            }
            if (p.y - 1 >= 0) {
                if (grid[p.x][p.y - 1] != 1) {
                    seaCount--;
                    grid[p.x][p.y - 1] = 1;
                    addLand.add(new Point(p.x, p.y - 1));
                }
            }
            if (p.x + 1 < m) {
                if (grid[p.x + 1][p.y] != 1) {
                    seaCount--;
                    grid[p.x + 1][p.y] = 1;
                    addLand.add(new Point(p.x + 1, p.y));
                }
            }
            if (p.y + 1 < n) {
                if (grid[p.x][p.y + 1] != 1) {
                    seaCount--;
                    grid[p.x][p.y + 1] = 1;
                    addLand.add(new Point(p.x, p.y + 1));
                }
            }
        }
        q.addAll(addLand);
        ret ++;
        if(seaCount > 0){
            return getMaxDistance(grid, addLand,seaCount,ret);
        }else{
            return ret;
        }
    }

}
