package LCP.game.firstDayBeenInAllRooms;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/9/5 10:55
 * @Description:
 */
public class Solution {

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] times = new int[n];
        int end = n;
        long day = 0L;
        int cur = 0;
        while(end > 0){
            if(times[cur] == 0){
                end --;
            }
            times[cur] += 1;
            if(times[cur] % 2 == 1){
                cur = nextVisit[cur];
            }else{
                cur = (cur + 1) % n;
            }
            day += 1;
        }
        System.out.println(Arrays.toString(times));
        return (int)(day - 1) % 1000000007;
    }

    public static void main(String[] args) {
//        int[] nextVisit = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nextVisit = {1,2,3,0};
        System.out.println(new Solution().firstDayBeenInAllRooms(nextVisit));
    }
}
