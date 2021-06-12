package leetCode.easy.xorOperation;

public class Solution {

    public int xorOperation(int n, int start) {
        int result = start;
        for(int i = 1 ;i < n ; i++){
            result ^= start + 2 * i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1 ;
        int start = 7;
        int result = new Solution().xorOperation(n,start);
        System.out.println(result);
    }
}
