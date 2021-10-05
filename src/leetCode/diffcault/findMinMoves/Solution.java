package leetCode.diffcault.findMinMoves;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/9/29 19:39
 * @Description:
 */
public class Solution {

    public int findMinMoves(int[] machines){
        int total = Arrays.stream(machines).sum();
        int n = machines.length;
        if(total % n != 0){
            return -1;
        }
        int avg = total / n;
        int ans = 0;
        for(int num : machines){
            if(num > avg){
                ans += (num - avg);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] machtines = {1,0,5};
        System.out.println(new Solution().findMinMoves(machtines));
    }
}
