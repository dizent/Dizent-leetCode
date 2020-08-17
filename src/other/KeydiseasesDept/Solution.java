package other.KeydiseasesDept;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

    static String[] firstDepts = new String[]{"临床", "急诊"};

    static String[][] department_names = new String[][]{
            {"消化内科", "呼吸内科", "心血管内科", "老年病科"}, {"传染病科室", "会诊中心"}
    };

    static String[] ICD_10 = new String[]{
            "恶性肿瘤术后化疗", "慢性肾功能衰竭", "糖尿病", "结节性甲状腺肿", "肺炎", "脑梗塞","慢性阻塞性肺疾病","肺泡性肺炎","急性胰腺炎","尿毒症"
    };

    static String[] types = new String[]{
            "出院人次", "住院天数", "平均住院日", "住院例数", "死亡例数", "1月内再住院例数", "2周再住院例数", "应收费用", "平均住院费用"
    };

    static Integer[] department_nums = new Integer[]{
            2000
    };

    static Integer baseNum = 30;

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
                Integer typeIndex = 0 ;
                for (int index = 0; index < firstDepts.length; index++) {
                    for (int i = 0; i < department_names[index].length; i++) {
                        Map<String, Object> monthObj = new HashMap<>();
                        for (int startLevel = 0; startLevel < types.length; startLevel++) {
                            monthObj.put(types[startLevel], baseNum + random.nextInt(department_nums[0]));
                        }
                        monthObj.put("firstDept", firstDepts[index]);
                        monthObj.put("secondDept", department_names[index][i]);
                        monthObj.put("ICD_10",ICD_10[typeIndex++]);
                        monthObj.put("year", startYear);
                        monthObj.put("month", month);
                        monthObj.put("recDate", startYear + "年" + month + "月");
                        monthData.add(monthObj);
                    }
                    returnList.addAll(monthData);
                    String monthResult = JSONObject.toJSONString(monthData);
                    jedis.hset("keyDiseaseDept_hash", startYear + "_" + month, monthResult);
                }
            }
            List<Map<String, Object>> yearData = new ArrayList<>();
            Integer typeIndex = 0 ;
            for (int index = 0; index < firstDepts.length; index++) {
                for (int i = 0; i < department_names[index].length; i++) {
                    Map<String, Object> yearObj = new HashMap<>();
                    for (int startLevel = 0; startLevel < types.length; startLevel++) {
                        yearObj.put(types[startLevel], baseNum + random.nextInt(department_nums[0]) * 12);
                    }
                    yearObj.put("firstDept", firstDepts[index]);
                    yearObj.put("secondDept", department_names[index][i]);
                    yearObj.put("ICD_10",ICD_10[typeIndex++]);
                    yearObj.put("year", startYear);
                    yearObj.put("month", "");
                    yearObj.put("recDate", startYear + "年");
                    yearData.add(yearObj);
                }
                returnList.addAll(yearData);
                String yearResult = JSONObject.toJSONString(yearData);
                jedis.hset("keyDiseaseDept_hash", startYear + "#", yearResult);
            }
        }
        String result = JSONObject.toJSONString(returnList);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateData());
    }
}
