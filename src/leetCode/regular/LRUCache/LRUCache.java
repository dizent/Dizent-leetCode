package leetCode.regular.LRUCache;

import java.util.*;

/**
 * @Auther: 布谷
 * @Date: 2021/8/26 09:51
 * @Description:
 */
public class LRUCache {

    int capacity;
    Map<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
        }
        cache.put(key,value);
        if(cache.size() > capacity){
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
    }
}
