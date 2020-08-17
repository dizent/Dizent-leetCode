package leetCode.easy.uniqueOccurrences;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        int[] countArr = new int[45];
        for(int i = 0;i< 45 ;i++){
            if(i == 0){
                countArr[i] = 1;
            }else {
                countArr[i] = countArr[i-1] + i + 1;
            }
        }
        for(int i = 0;i< 45 ;i++){
            if(countArr[i] == arr.length){
                System.out.println("num`s num is "+(i+1));
                Map<Integer,Integer> timeMap = new HashMap<>();
                for(int j = 0 ;j < arr.length; j++){
                    if(timeMap.get(arr[j])==null){
                        timeMap.put(arr[j],1);
                        if(timeMap.size() > i + 1){
                            return false;
                        }
                    }else{
                        timeMap.put(arr[j],timeMap.get(arr[j])+1);
                    }
                }
                Object[] objarr = timeMap.values().toArray();
                for(int k = 0;k<objarr.length-1; k++){
                    for(int l = 1;l<objarr.length;l++){
                        if(objarr[k] == objarr[l] && k != l){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
