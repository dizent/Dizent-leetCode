package leetCode.easy.numEquivDominoPairs;
import	java.util.Calendar;

import java.util.Arrays;
import java.util.Date;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] result = new int[100];
        for(int i = 0;i<dominoes.length;i++){
            Arrays.sort(dominoes[i]);
            count += result[dominoes[i][0]*10+dominoes[i][1]]++;
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(new Solution().numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{5,6}}));
        System.out.println(System.currentTimeMillis()-start);
        new Solution().testCleander();
    }

    public void testCleander(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        System.out.printf("【开始时间】：年[%d], 月[%d], 日[%d]", cal.get(Calendar.YEAR),  cal.get(Calendar.MONTH),  cal.get(Calendar.DAY_OF_MONTH));
    }
}
