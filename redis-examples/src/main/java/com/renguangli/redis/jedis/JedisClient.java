package com.renguangli.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * JedisClient
 *
 * @author renguangli 2018/9/7 18:29
 * @since JDK 1.8
 */
public class JedisClient {

    private static volatile Jedis jedis;

    private JedisClient(){}

    public static Jedis getJedis() {
        if (jedis == null) {
            synchronized (JedisClient.class) {
                if (jedis == null) {
                    jedis = new Jedis("172.16.11.129", 6379, 10000, 10000);
                }
            }
        }
        return jedis;
    }

}
