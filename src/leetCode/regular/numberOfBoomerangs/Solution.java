package leetCode.regular.numberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 布谷
 * @Date: 2021/9/13 11:10
 * @Description:
 */
public class Solution {


    /**
     * 解法 I ：
     * 遍历点之间的距离，使用距离做 Key，value为点的数量
     * 将hash表中的数据相加，距离相同的点数量 n ， count = n * (n - 1)
     *
     * 时间复杂度 ： O(n²)
     * 空间复杂度 ： O(n)
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int[] p : points){
            Map<Integer,Integer> cnt = new HashMap<>();
            for(int[] q :points){
                int xl = p[0] - q[0];
                int yl = p[1] - q[1];
                int dis = xl * xl + yl * yl;
                cnt.put(dis,cnt.getOrDefault(dis,0) + 1);
            }
            for(Map.Entry<Integer,Integer> entry:cnt.entrySet()){
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(new Solution().numberOfBoomerangs(points));
    }


}
