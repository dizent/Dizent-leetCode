package newcoder.sort;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/9/10 09:23
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] nums = {10,60,5,31,9,45,71};
        sort.sort(nums);
        System.out.printf(Arrays.toString(nums));
    }

    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int star, int end) {
        if (star > end) {
            return;
        }
        int i = star;
        int j = end;
        int key = nums[star];
        while (i < j) {
            while (i < j && nums[j] > key) {
                j--;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[star] = nums[i];
        nums[i] = key;
        quickSort(nums, star, i - 1);
        quickSort(nums, i + 1, end);
    }
}
