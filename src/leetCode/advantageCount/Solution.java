package leetCode.advantageCount;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class Solution {

    private int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        Arrays.sort(A);
        int[] result = new int[length];
        boolean[] getFlag = new boolean[length];
        for(int i = 0;i<length; i++){
            int minSub = (int) Math.pow(10,9);
            int minJ = -1;
            int j = 0;
            boolean flag = false;
            while(j < length){
                int sub = A[j]-B[i];
                if(sub > 0 && !getFlag[j]){
                    flag = true;
                    if(minSub > sub){
                        minSub = sub;
                        minJ = j;
                    }
                }
                j++;
            }
            if(flag){
                result[i] = A[minJ];
                getFlag[minJ] = true;
            }else{
                for(int k = 0;k<length;k++){
                    if(!getFlag[k]){
                        result[i] = A[k];
                        getFlag[k] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,0,4,1,2};
        int[] b = new int[]{1,3,0,0,2};
        System.out.println(JSONObject.toJSONString(new Solution().advantageCount(a,b)));
    }
}
