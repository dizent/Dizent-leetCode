package other.medicalTechnologyNum;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

    static String[] kindArr = new String[]{
            "医生人数","护理人员数","医技人数"
    };

    static String[] department_names = new String[]{
            "消化内科","呼吸内科","心血管内科","老年病科"
    };
    static Integer[] department_nums = new Integer[]{
            200
    };

    public String generateData(){
        Jedis jedis = new Jedis("192.168.10.180",6379);
        jedis.auth("123456");
        jedis.select(1);
        String ping = jedis.ping();

        Random random = new Random();
        List returnList = new ArrayList();
        for(int index = 0;index < kindArr.length ; index++) {
            List<Map<String,Object>> levelData = new ArrayList<>();
            for (int i = 0; i < department_names.length; i++) {
                Map<String, Object> levelObj = new HashMap<>();
                levelObj.put("kind", kindArr[index]);
                levelObj.put("firstDept", "门诊科室");
                levelObj.put("secondDept", department_names[i]);
                if(i == 0) {
                    levelObj.put("detailDept", "明细科室");
                }else{
                    levelObj.put("detailDept", "");
                }
                levelObj.put("num", random.nextInt(department_nums[0]));
                levelData.add(levelObj);
            }
            returnList.addAll(levelData);
            String levelResult = JSONObject.toJSONString(levelData);

            jedis.hset("medicalSkillNum_hash",kindArr[index],levelResult);
        }
        String result = JSONObject.toJSONString(returnList);
        jedis.hset("medicalSkillNum_hash","all",result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateData());
    }
}
