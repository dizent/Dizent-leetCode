package leetCode.regular.smallestRangeII;

import java.util.Arrays;

public class Solution {

    public int smallestRangeII(int[] A, int K) {
        int[] arr = Arrays.copyOf(A,A.length);
        Arrays.sort(arr);
        int len = arr.length;
        int res = arr [len-1] -arr[0];
        for(int i = 1;i<len;i++){
            int min = Math.min(arr[0] + K,arr[i]-K);
            int max = Math.max(arr[len-1] - K,arr[i-1] + K);
            res = Math.min(max - min,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int []{0,10};
        int k = 2;
        System.out.println(new Solution().smallestRangeII(arr,k));
    }
}
