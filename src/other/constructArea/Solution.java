package other.constructArea;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Solution {

    static String[] firstDepts = new String[]{"临床", "行政后勤"};

    static String[][] department_names = new String[][]{
            {"消化内科", "呼吸内科", "心血管内科", "老年病科"}, {"门诊办公室", "会诊中心"}
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
        List returnList = new ArrayList();
        List<Map<String, Object>> levelData = new ArrayList<>();
        for (int index = 0; index < firstDepts.length; index++) {
            for (int i = 0; i < department_names[index].length; i++) {
                Map<String, Object> levelObj = new HashMap<>();
//                levelObj.put("level", startLevel+"类手术");
                levelObj.put("firstDept", firstDepts[index]);
                levelObj.put("secondDept", department_names[index][i]);
                if(i == 0 ) {
                    levelObj.put("detailDept", "明细科室" + index);
                }else{
                    levelObj.put("detailDept", "");

                }
                levelObj.put("area", random.nextInt(department_nums[0]));
                levelData.add(levelObj);
            }
        }
        String levelResult = JSONObject.toJSONString(levelData);
        jedis.set("constructArea",levelResult);
        return levelResult;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateData());
    }
}
