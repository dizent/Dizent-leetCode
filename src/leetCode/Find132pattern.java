package leetCode;


public class Find132pattern {


    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int leftMin = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i-1]<leftMin){
                leftMin = nums[i-1];
            }
            if(nums[i]<leftMin) continue;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] > nums[k] && leftMin < nums [k]) {
                    return true;
                }
            }

        }
        return false;
    }

}
