package leetCode.regular.matrixScore;

public class Solution {

    public int matrixScore(int[][] A) {
        int[] count = new int[A[0].length];
        int result = 0;
        for (int[] ints : A) {
            if (ints[0] == 0) {
                for(int i = 0;i<ints.length;i++){
                    ints [i] = ints[i]^1;
                }
            }
            for(int n = 0 ;n<ints.length;n++){
                count[n] += ints[n];
            }
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] <= A.length / 2){
                for(int matrix = 0;matrix<A.length;matrix++) {
                    A[matrix][i] = A[matrix][i] ^ 1;
                    if(A[matrix][i] == 1) {
                        result += 1 << A[matrix].length - i - 1;
                    }
                }
            }else{
                for (int[] ints : A) {
                    if (ints[i] == 1) {
                        result += 1 << ints.length - i - 1;
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args){
        int[][] A = new int[][]{{0,0,0},{1,0,0},{0,1,1}};
        System.out.println(new Solution().matrixScore(A));
    }
}
