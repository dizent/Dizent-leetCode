package leetCode.easy.readBinaryWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dizent
 */
public class Solution {


    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> result = new ArrayList<>();
        for(int hour = 0;hour <= 11;hour ++){
            for(int minute = 0; minute <= 59;minute++){
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn){
                    String prefix = minute > 9 ? "" : "0";
                    result.add(hour + ":" + prefix + minute);
                }
            }
        }
        return result;

    }

    public List<String> readBinaryWatch(int turnedOn) {
        Map<Integer,List<Integer>> timeBinaryMap = new HashMap<>();
        initTimeBinaryMap(timeBinaryMap,59);
        List<String> timeList = new ArrayList<>();
        for(int hour = 0; hour <= turnedOn || hour <= 3 ; hour++){
            List<Integer> hourStrs = timeBinaryMap.get(hour);
            List<Integer> minuteStrs = timeBinaryMap.get(turnedOn - hour);
            if(hourStrs == null || minuteStrs == null) {
                continue;
            }
            hourStrs.forEach( hourStr -> {
                if(hourStr <= 11) {
                    minuteStrs.forEach(minuteStr -> {
                        timeList.add(hourStr + ":" + (minuteStr > 9 ? minuteStr : "0" + minuteStr));
                    });
                }
            });
        }
        return timeList;
    }


    public void initTimeBinaryMap(Map<Integer,List<Integer>> initMap, int maxNum){
        for(int i = 0;i <= maxNum;i++){
            int binaryNum = 0;
            int temp = i;
            while(temp > 0){
                binaryNum += temp & 1;
                temp >>= 1;
            }
            List<Integer> numList = initMap.getOrDefault(binaryNum,new ArrayList<>());
            numList.add( i);
            initMap.put(binaryNum,numList);
        }
    }

    public static void main(String[] args) {
        List<String> result = new Solution().readBinaryWatch2(5);
        result.stream().forEach(r->{
            System.out.print(r+"\t");
        });
    }
}
