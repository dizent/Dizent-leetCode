package other.timeLine;

import com.alibaba.fastjson.JSONObject;
import other.RedisUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int[] years = new int[]{2018,2019,2020};
    static int[] months = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};

    public String generateTimeLine(){
        List<TimeLine> timeLines = new ArrayList<>();

        for(int y = 0;y < years.length ; y++){
            TimeLine yearTime = new TimeLine(years[y],"年");
            timeLines.add(yearTime);
            for(int m = 0;m < months.length;m++){
                TimeLine monthTime = new TimeLine(months[m],"月");
                monthTime.setParentTimeValue(years[y]);
                timeLines.add(monthTime);
            }
        }
        String result = JSONObject.toJSONString(timeLines);
        RedisUtils.getConnection().set("timeLine", result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTimeLine());
    }
}
