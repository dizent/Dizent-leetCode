package other.exactOpenBedNum;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

        static String[] firstDepts = new String[]{
                "临床"
        } ;

        static Map<String,String[]> secondDepts = new HashMap<String,String[]>();

        static{
            secondDepts.put("内科学",new String[]{"普内科门诊","神经内科门诊","呼吸内科门诊"});
            secondDepts.put("外科学",new String[]{"普外科门诊","神经外科门诊","手外科门诊","骨科门诊"});
            secondDepts.put("耳鼻咽喉科学",new String[]{"耳鼻咽喉科门诊"});
        }
        static Integer[] department_nums = new Integer[]{
                500
        };

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
                for(int season = 1;season <= 4; season++) {
                    List<Map<String,Object>> data = new ArrayList<>();
                    Iterator<Map.Entry<String,String[]>> iterator = secondDepts.entrySet().iterator();
                    while(iterator.hasNext()) {
                        Map.Entry<String,String[]> entry = iterator.next();
                        String[] thirdDepts = entry.getValue();
                        for(int i = 0;i<thirdDepts.length;i++) {
                            Map<String, Object> obj = new HashMap<>();
                            obj.put("year", startYear);
                            obj.put("season", season);
                            obj.put("firstDept", firstDepts[0]);
                            obj.put("secondDept", entry.getKey());
                            obj.put("thirdDept", thirdDepts[i]);
                            obj.put("openBedNum", random.nextInt(department_nums[0]));
                            obj.put("incDate","第"+season+"季度");
                            data.add(obj);
                        }
                    }
                    returnList.add(data);
                    String result = JSONObject.toJSONString(data);
                    if("PONG".equals(ping)){
                        jedis.select(1);
                        jedis.hset("fact_openBedNum_hash",startYear + "_" + season,result);
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
