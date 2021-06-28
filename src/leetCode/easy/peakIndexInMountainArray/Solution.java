package leetCode.easy.peakIndexInMountainArray;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int pre = 0;
        int cur = (arr.length - 1) / 2;
        int end = arr.length - 1;
        while(pre < end){
            if(arr[cur - 1] > arr[cur]){
                end = cur;
                cur = pre + (end - pre) / 2;
                continue;
            }
            if(arr[cur + 1] > arr[cur]){
                pre = cur;
                cur = pre + (end - pre) / 2;
                continue;
            }
            if(arr[cur - 1] < arr[cur] && arr[cur + 1] < arr[cur]){
                return cur;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{24,69,100,99,79,78,67,36,26,19};
        System.out.println(new Solution().peakIndexInMountainArray(arr));
    }
}
