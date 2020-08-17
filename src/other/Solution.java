package other;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

    static String[] firstDepts = new String[]{"临床", "急诊"};

    static String[][] department_names = new String[][]{
            {"消化内科", "呼吸内科", "心血管内科", "老年病科"}, {"传染病科室", "会诊中心"}
    };
    static Integer[] department_nums = new Integer[]{
            2800
    };

    Integer baseNum = 100;

    public String generateData(){
        Jedis jedis = new Jedis("192.168.10.180",6379);
        jedis.auth("123456");
        String ping = jedis.ping();
        Integer startYear = 2018;
        Integer endYear = 2020;
        Random random = new Random();
        List returnList = new ArrayList();
        for(;startYear <= endYear ; startYear++) {
            List<Map<String,Object>> yearData = new ArrayList<>();
            for (int index = 0; index < firstDepts.length; index++) {
                for (int i = 0; i < department_names[index].length; i++) {
                    Map<String, Object> yearObj = new HashMap<>();
                    yearObj.put("year", startYear);
                    yearObj.put("firstDept", firstDepts[index]);
                    yearObj.put("secondDept", department_names[index][i]);
                    yearObj.put("recDate", startYear + "年");
                    yearObj.put("outpatientNum", baseNum * 12 + random.nextInt(department_nums[0]) * 12);
                    yearData.add(yearObj);
                }
            }
            String yearResult = JSONObject.toJSONString(yearData);

            for(int month = 1;month <= 12; month++) {
                List<Map<String,Object>> data = new ArrayList<>();
                for (int index = 0; index < firstDepts.length; index++) {
                    for (int i = 0; i < department_names[index].length; i++) {
                        Map<String, Object> obj = new HashMap<>();
                        obj.put("year", startYear);
                        obj.put("month", month);
                        obj.put("firstDept", firstDepts[index]);
                        obj.put("secondDept", department_names[index][i]);
                        obj.put("outpatientNum", random.nextInt(department_nums[0]) + baseNum);
                        obj.put("recDate", startYear + "年" + month + "月");
                        data.add(obj);
                    }
                }
                returnList.add(data);
                String result = JSONObject.toJSONString(data);
                if("PONG".equals(ping)){
                    jedis.select(1);
                    jedis.hset("fact_register_hash",startYear + "_" + month,result);
                    jedis.close();
                }
            }
            if("PONG".equals(ping)){
                jedis.select(1);
                jedis.hset("fact_register_hash",startYear + "#",yearResult);
                jedis.close();
            }
        }
        return JSONObject.toJSONString(returnList);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateData());
    }
}
