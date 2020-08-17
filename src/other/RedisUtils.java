package other;

import redis.clients.jedis.Jedis;

public class RedisUtils {

    public static Jedis getConnection(){
        Jedis jedis = new Jedis("192.168.10.180",6379);
        jedis.auth("123456");
        jedis.select(1);
        return jedis;
    }

    public void close(Jedis jedis){
        jedis.close();
    }


}
