package other.icuOpenBedNum;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

    static String[] thirdDept = new String[]{
            "住院部"
    } ;

    static Map<String,String[]> fourthDept = new HashMap<String,String[]>();

    static{
        fourthDept.put("ICU病房5",new String[]{"ICU病房5-1","ICU病房5-2","ICU病房5-3"});
        fourthDept.put("SICU6",new String[]{"SICU6-1","SICU6-2"});
        fourthDept.put("病区五",new String[]{"病区五(5-4A)"});
    }
    static Integer[] department_nums = new Integer[]{
            20
    };

    public String generateData(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.auth("123456");
        String ping = jedis.ping();
        Integer startYear = 2018;
        Integer endYear = 2020;
        Random random = new Random();
        List returnList = new ArrayList();
        for(;startYear <= endYear ; startYear++) {
            List<Map<String,Object>> yearData = new ArrayList<>();
            for(int month = 1;month <= 12; month++) {
                List<Map<String,Object>> data = new ArrayList<>();
                Iterator<Map.Entry<String,String[]>> iterator = fourthDept.entrySet().iterator();
                while(iterator.hasNext()) {
                    Map.Entry<String,String[]> entry = iterator.next();
                    String[] fourthDepts = entry.getValue();
                    for(int i = 0;i<fourthDepts.length;i++) {
                        Map<String, Object> obj = new HashMap<>();
                        obj.put("year", startYear);
                        obj.put("belongYear", startYear);
                        obj.put("month", month);
//                        obj.put("firstDept", firstDepts[0]);
//                        obj.put("secondDept", entry.getKey());
                        obj.put("thirdDept", thirdDept[0]);
                        obj.put("fourthDept", entry.getKey());
                        obj.put("detailDept", fourthDepts[i]);
                        obj.put("openBedNum", random.nextInt(department_nums[0]));
                        obj.put("incDate",startYear + "年" + month + "月");
                        data.add(obj);
                    }
                }
                returnList.add(data);
                String result = JSONObject.toJSONString(data);
                if("PONG".equals(ping)){
                    jedis.select(1);
                    jedis.hset("fact_icuOpenBedNum_hash",startYear + "_" + month,result);
                    jedis.close();
                }
            }
        }
        return JSONObject.toJSONString(returnList);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateData());
    }
}
