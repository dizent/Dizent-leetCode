package leetCode.easy.maxProductDifference;

/**
 * @Auther: 布谷
 * @Date: 2021/6/27 10:32
 * @Description:
 */
public class Solution {
    public int maxProductDifference(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int secMaxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int secMinNum = Integer.MAX_VALUE;
        for (int currNum : nums) {
            if(currNum > secMaxNum){
                if(currNum > maxNum){
                    secMaxNum = maxNum;
                    maxNum = currNum;
                }else{
                    secMaxNum = currNum;
                }
            }
            if (currNum < secMinNum) {
                if(currNum < minNum){
                    secMinNum = minNum;
                    minNum = currNum;
                }else{
                    secMinNum = currNum;
                }
            }
        }
        return maxNum * secMaxNum - minNum * secMinNum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,3,4,6,5};
        System.out.println(new Solution().maxProductDifference(arr));

    }
}
