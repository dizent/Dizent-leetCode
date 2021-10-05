package LCP.game.interchangeableRectangles;

import java.util.*;
import java.util.Map.Entry;

/**
 * @Auther: 布谷
 * @Date: 2021/9/12 10:45
 * @Description:
 */
public class Solution {

    /**
     * 计算比例，等到rectangle.length个比例，将其分组，同一组的都可以交换
     * 长度 = 1，不可交换
     * = 2，1对
     * = 3，3对
     * = 4，6对
     * 公式（1 + n）* n / 2
     * <p>
     * 当一个矩形可以和别的矩形交换的时候，等于可以和能和这个矩形交换的所有矩形交换
     * boolean dp[i][j] 表示 i 和 j 可交换
     *
     * @param rectangles
     * @return
     */
    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0L;
        Map<Double,Long> groupMap = new HashMap<>();
        for (int[] ints : rectangles) {
            Double rectangle = (double) ints[1] / (double) ints[0];
            if (groupMap.containsKey(rectangle)) {
                groupMap.put(rectangle, groupMap.get(rectangle) + 1L);
            } else {
                groupMap.put(rectangle, 1L);
            }
        }
        for(HashMap.Entry<Double,Long> group :groupMap.entrySet()){
            if(group.getValue() <= 1){
                continue;
            }
            long n = group.getValue() - 1;
            result += (n+1) * n / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{2,4},{4,8},{3,6},{5,10}};
        System.out.println(new Solution().interchangeableRectangles(rectangles));
    }
}
