package leetCode.regular.LRUCache;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * @Auther: 布谷
 * @Date: 2021/8/26 09:51
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(JSONObject.toJSONString(cache));
    }
}
