package leetCode.easy.reverseBits;

public class Solution {

    public int reverseBits(int n) {
        int[] bits = new int[32];
        int index = 0;
        while (n != 0) {
            bits[index] = n & 1;
            n >>>= 1;
            index++;
        }
        boolean integerFlag = true;
        for (int i = 0; i < bits.length; i++) {
            n |= bits[i];
            if(i != bits.length - 1) {
                n <<= 1;
            }
            System.out.println("n = " + n + "\t || binary = : " + Integer.toBinaryString(n) + "\ti = " + i);

        }
        int result = n * (integerFlag ? 1 : -1);
        System.out.println(Integer.toBinaryString(result));
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n >>>= 1;
            result |= bit;
            if(i != 31) {
                result <<= 1;
            }
            System.out.println("n = " + n + "\t || binary = : " + Integer.toBinaryString(n) + "\ti = " + i);
            System.out.println("result = " + result + "\t || binary = : " + Integer.toBinaryString(result) + "\ti = " + i);
        }
        System.out.println(Integer.toBinaryString(result));
        return result;
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new Solution().reverseBits2(n));
    }
}
