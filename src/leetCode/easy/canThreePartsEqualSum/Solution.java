package leetCode.easy.canThreePartsEqualSum;

public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int count = 0;
        for(int a:A){
            count += a;
        }
        if(count % 3 != 0){
            return false;
        }
        int part = count / 3;
        int front = 0;
        int frontIdx = 0;
        int back = 0;
        int backIdx = 0;
        for(int i = 0;i<A.length;i++){
            front += A[i];
            if(front == part){
                frontIdx = i;
                break;
            }
        }
        if(frontIdx >= A.length - 1){
            return false;
        }
        for(int i = A.length - 1;i > frontIdx; i--){
            back += A[i];
            if(back == part){
                backIdx = i;
                break;
            }
        }
        return backIdx - frontIdx > 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canThreePartsEqualSum(new int[]{18,12,-18,18,-19,-1,10,10}));
    }
}
