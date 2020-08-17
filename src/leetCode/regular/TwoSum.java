package leetCode.regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSum2(nums,target);
        System.out.println(result);
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for(int i = 0;i< nums.length;i++){
            for(int j = i+1;j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> list = new ArrayList<> ();
        Arrays.stream(nums).forEach(list::add);
        for(int i = 0;i<nums.length; i++) {
            int index = list.indexOf(target - nums[i]);
            if(index!= -1 && i != index){
                result[0] = i;
                result[1] = index;
                return result;
            }
        }
        return result;
    }
}
