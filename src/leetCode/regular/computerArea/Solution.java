package leetCode.regular.computerArea;

/**
 * @Auther: 布谷
 * @Date: 2021/9/30 20:25
 * @Description:
 */
public class Solution {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int alength = ax2 - ax1;
        int awidth = ay2 - ay1;
        int blength = bx2 - bx1;
        int bwidth = by2 - by1;
        int overLength = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        int overwidth = Math.min(ay2,by2) - Math.max(ay1,by1);
        if(overLength >= 0 && overwidth >= 0) {
            return alength * awidth + blength * bwidth - overLength * overwidth;
        }
        return alength * awidth + blength * bwidth;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-2,
        -2,
                2,
                2,
                2,
                2,
                4,
                4
        ));
    }
}
