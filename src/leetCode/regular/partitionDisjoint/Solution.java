package leetCode.regular.partitionDisjoint;

public class Solution {

    public int partitionDisjoint(int[] A){
        int min = A.length - 1;
        //先找到最小值的位置，一定在左边
        for(int i = A.length-1;i>=0;i--){
            if(A[i] <= A[min]){
                min = i;
            }
        }
        //判断左边是不是都小于右边
        int leftMax = A[min];
        for(int i = 0;i <= min;i++){
            if(A[i] > leftMax){
                leftMax = A[i];
            }
        }
        boolean flag = true;
        while(flag) {
            int middleMax = A[min+1];
            for (int i = min + 1; i < A.length; i++) {
                if(A[i] > middleMax){
                    middleMax = A[i];
                }
                if (A[i] < leftMax) {
                    min = i;
                    if(middleMax > leftMax){
                        leftMax = middleMax;
                    }
                }
            }
            flag = false;
        }
        return min + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionDisjoint(new int[]{29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88}));
    }

}
