package leetCode.easy.plusOne;

import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        //只有0会以0开头
        if (digits[0] == 0) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        int plusDigits = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digitNum = digits[i] + plusDigits;
            digits[i] = digitNum % 10;
            plusDigits = digitNum / 10;
        }
        if (plusDigits == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        System.out.println(Arrays.toString(new Solution().plusOne(nums)));
    }
}
