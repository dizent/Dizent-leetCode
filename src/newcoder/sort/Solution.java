package newcoder.sort;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/8/31 15:15
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {4,3,7,9,1,6,7,2};
        new MergeSort().mergeSort(0, arr.length - 1,arr);
//        arr = new MergeSort().mySort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
