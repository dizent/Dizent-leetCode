package leetCode.easy.toHex;

/**
 * @Auther: 布谷
 * @Date: 2021/10/2 20:04
 * @Description:
 */
public class Solution {

    char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int[] strIndex = new int[8];
        boolean preZero = true;
        for (int i = 31; i >= 0; i--) {
            int n = 1 << i;
            int resIndex = 7 - (i / 4);
            if ((num & n) != 0) {
                strIndex[resIndex] += Math.pow(2, (i % 4));
            }
            if (i % 4 == 0) {
                if (!preZero || strIndex[resIndex] != 0) {
                    sb.append(hexChar[strIndex[resIndex]]);
                    preZero = false;
                }
            }
        }
        return sb.toString();
    }

    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean preZero = true;
        for (int i = 7; i >= 0; i--) {
            int n = num >>> (4 * i);
            num -= n << (4 * i);
            if (!preZero || n != 0) {
                sb.append(hexChar[n]);
                preZero = false;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(new Solution().toHex2(num));
    }
}
