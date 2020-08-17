package leetCode.easy.rotatedDigits;

public class Solution {

    public int rotatedDigits(int N) {
        int[] goodArr = new int[]{2,2,1,0,0,1,1,0,2,1};
        int count = 0;
        for(int i = 1;i <= N;i++){
            int occu = i;
            boolean occuCount = false;
            while (occu >= 1){
                int num = occu % 10;
                if(goodArr[num] == 0){
                    occuCount = false;
                    break;
                }
                if(goodArr [num] == 1){
                    occuCount = true;
                }
                occu /= 10;
            }
            count += occuCount?1:0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(200));
    }
}
