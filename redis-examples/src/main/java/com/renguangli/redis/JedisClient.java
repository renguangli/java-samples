package com.renguangli.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * JedisPools
 *
 * @author renguangli 2018/9/7 18:29
 * @since JDK 1.8
 */
public class JedisClient {

    private static volatile JedisPool jedisPool;

    private JedisClient(){}

    public static Jedis getJedis() {
        return getJedisPool().getResource();
    }

    private static JedisPool getJedisPool() {
        if (jedisPool == null) {
            synchronized (JedisClient.class) {
                if (jedisPool == null) {
                    jedisPool = new JedisPool();
                }
            }
        }
        return jedisPool;
    }

}
