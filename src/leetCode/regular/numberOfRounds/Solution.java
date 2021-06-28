package leetCode.regular.numberOfRounds;

/**
 * @Auther: 布谷
 * @Date: 2021/6/25 16:41
 * @Description:
 */
public class Solution {

    public int numberOfRounds(String startTime, String finishTime) {
        int startHH = Integer.parseInt(startTime.substring(0,2));
        int startMM = Integer.parseInt(startTime.substring(3));
        int endHH = Integer.parseInt(finishTime.substring(0,2));
        int endMM = Integer.parseInt(finishTime.substring(3));
        if(startHH == endHH && endMM - startMM < 15){
            return 0;
        }

//        int[][] time = new int[96][2];
//        for(int i = 0;i < time.length; i++){
//            int hourIndex = i / 4;
//            int minutesIndex = (i % 4) * 15;
//            time[i] = new int[]{hourIndex, minutesIndex};
//        }

        int startIndex = startHH * 4 + (startMM + 14) / 15;
        int endIndex = endHH * 4 + endMM / 15;
        if(endIndex < startIndex){
            return 96 - startIndex + endIndex;
        }
        return endIndex - startIndex;
    }

    public static void main(String[] args) {
        String startTime = "12:01";
        String finishTime = "12:44";
        System.out.println(new Solution().numberOfRounds(startTime,finishTime));
    }
}
