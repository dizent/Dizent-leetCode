package leetCode;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSumFun(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> sumSet = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();
        boolean exists = false;
        for(int i = 0;i<nums.length-2; i++){
            if(sumSet.contains(nums[i])) continue;
            for(int j = i+1;j < nums.length - 1 ; j++){
                for(int k = j+1;k<nums.length;k++){
                    List<Integer> newArr = new ArrayList<Integer>(Arrays.asList(nums[i],nums [j], nums [k]));
                    for(List<Integer> list:results){
                        if(compare(list,newArr)){
                            exists = true;
                            break;
                        }
                    }
                    if(exists){exists = false;break;}
                    if(nums[j] +nums[k] == -nums[i]){
                        results.add(newArr);
                        sumSet.add(nums[i]);
                    }
                }
            }
        }
        return results;
    }

    private boolean compare(List<Integer> one , List<Integer> two){
        one.sort(Integer::compareTo);
        two.sort(Integer::compareTo);
        return one.get(0).equals(two.get(0)) && one.get(1).equals(two.get(1)) && one.get(2).equals(two.get(2));
    }

    public void testList(){
    }
}
