package other.Scientificresearchresults;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

    static String[] firstDepts = new String[]{"临床", "行政后勤"};

    static String[][] department_names = new String[][]{
            {"消化内科", "呼吸内科", "心血管内科", "老年病科"}, {"门诊办公室", "会诊中心"}
    };

    static String[] types = new String[]{
            "额度", "课题数", "论文数/每百张开放床位数"
    };

    static Integer[] department_nums = new Integer[]{
            200
    };

    public String generateData() {
        Jedis jedis = new Jedis("192.168.10.180", 6379);
        jedis.auth("123456");
        jedis.select(1);
        String ping = jedis.ping();

        Random random = new Random();

        Integer startYear = 2018;
        Integer endYear = 2020;

        List returnList = new ArrayList();
        for (; startYear <= endYear; startYear++) {
            for (int month = 1; month <= 12; month++) {
                List<Map<String, Object>> monthData = new ArrayList<>();
                for (int index = 0; index < firstDepts.length; index++) {
                    for (int i = 0; i < department_names[index].length; i++) {
                        Map<String, Object> monthObj = new HashMap<>();
                        for (int startLevel = 0; startLevel < types.length; startLevel++) {
                            monthObj.put(types[startLevel], random.nextInt(department_nums[0]));
                        }
                        monthObj.put("firstDept", firstDepts[index]);
                        monthObj.put("secondDept", department_names[index][i]);
                        monthObj.put("year", startYear);
                        monthObj.put("month", month);
                        monthObj.put("recDate", startYear + "年" + month + "月");
                        monthData.add(monthObj);
                    }
                    returnList.addAll(monthData);
                    String monthResult = JSONObject.toJSONString(monthData);
                    jedis.hset("ScientificResearchResults_hash", startYear + "_" + month, monthResult);
                }
            }
            List<Map<String, Object>> yearData = new ArrayList<>();
            for (int index = 0; index < firstDepts.length; index++) {
                for (int i = 0; i < department_names[index].length; i++) {
                    Map<String, Object> yearObj = new HashMap<>();
                    for (int startLevel = 0; startLevel < types.length; startLevel++) {
                        yearObj.put(types[startLevel], random.nextInt(department_nums[0]));
                    }
                    yearObj.put("firstDept", firstDepts[index]);
                    yearObj.put("secondDept", department_names[index][i]);
                    yearObj.put("year", startYear);
                    yearObj.put("month", "");
                    yearObj.put("recDate", startYear + "年");
                    yearData.add(yearObj);
                }
                returnList.addAll(yearData);
                String yearResult = JSONObject.toJSONString(yearData);
                jedis.hset("ScientificResearchResults_hash", startYear + "#", yearResult);
            }
        }
        String result = JSONObject.toJSONString(returnList);
        return result;
    }

    public static void main(String[] args) {
        new Solution().generateData();
    }
}
