package leetCode.diffcault.smallestGoodBase;



public class Solution {

    public String smallestGoodBase(String n) {

        Long nValue = Long.parseLong(n);
        int maxKValue = (int)Math.log(nValue) + 1;
        for(int k = maxKValue;k >= 2;k--){
            //用二分法搜索对应的k,(k的含义是k进制)
            long left = 2, right = (long)Math.pow(nValue, 1.0 / (k-1)) + 1;
            while(left < right){
                long mid = left + (right - left) / 2, sum = 0;

                //等比数列求和
                for(int j = 0; j < k; j++)
                    sum = sum * mid + 1;

                if(sum == nValue)
                    return String.valueOf(mid);
                else if(sum < nValue)
                    left = mid + 1;
                else
                    right = mid;
            }
        }
        return String.valueOf(nValue - 1);
    }

    public static void main(String[] args) {
        String n = "41";
        System.out.println(new Solution().smallestGoodBase(n));
    }
}
