package leetCode.regular.maxIceCream;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/7/2 17:23
 * @Description:
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        int num = 0;
        Arrays.sort(costs);
        for(int i = 0;i < costs.length; i++){
            if (coins >= costs[i]) {
                num += 1;
                coins -= costs[i];
            }else{
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{1,3,2,4,1};
        int coins = 3;
        System.out.println(new Solution().maxIceCream(costs,coins));
    }
}
