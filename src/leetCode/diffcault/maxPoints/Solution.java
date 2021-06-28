package leetCode.diffcault.maxPoints;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 布谷
 */
public class Solution {

    /**
     * 思路：
     * 1.两点确定一条直线
     * 2.确定第三个点是不是也在同一条直线上
     * 3.已知-> 两个点能确定一条直线的斜率，当A-B的斜率 = B-C的斜率的时候，证明ABC在同一点上
     * 4.将每个二维数组的x，从小到大排序，存储每两个点之间的斜率，再进行下一步操作
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }
        double[][] flexRate = new double[points.length][points.length];
        AtomicInteger maxPoints = new AtomicInteger();
        for (int a = 0; a < points.length; a++) {
            Map<Double,Integer> rateTimeMap = new HashMap<>();
            for (int b = 0; b < points.length; b++) {
                int[] aPoint = points[a];
                int[] bPoint = points[b];
                double abRate = 0.0;
                if (a != b) {
                    if(a < b) {
                        /**
                         * 如果y相同，则在一个横线上，是一个无限接近于0 的小数
                         * 因为 -10000 <= xi, yi <= 10000
                         * 并且没有完全相同的点
                         * 所以 abRate 比 20000 / 1 更大即可
                         */
                        if ((aPoint[1] - bPoint[1]) == 0) {
                            abRate = 20001;
                        } else {
                            abRate = (double) (aPoint[0] - bPoint[0]) / (double) (aPoint[1] - bPoint[1]);
                        }
                    }else{
                        abRate = flexRate[b][a];
                    }
                    rateTimeMap.put(abRate,rateTimeMap.getOrDefault(abRate,1) + 1);
                }
                flexRate[a][b] = abRate;
            }
            rateTimeMap.forEach((rate,time)->{
                maxPoints.set(Math.max(maxPoints.get(), time));
            });
        }
        return maxPoints.get();
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{4, 5}};
        System.out.println(new Solution().maxPoints(points));
    }
}
