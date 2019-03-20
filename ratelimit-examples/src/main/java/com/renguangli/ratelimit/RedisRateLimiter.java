package com.renguangli.ratelimit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ratelimit-examples
 * Created by renguangli at 2019/2/18 16:26
 *
 * @since JDK1.8
 */
public class RedisRateLimiter extends AbstractRateLimiter {

    private static String LUA_SCRIPT = null;

    private static JedisPool jedisPool;

    static {
        jedisPool = new JedisPool(new JedisPoolConfig(),"172.16.11.140",6379, 2000,"123456");
        // 加载Lua代码
        try {
            LUA_SCRIPT = Resources.getResourceAsString("ratelimit.lua");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RedisRateLimiter() {}

    public RedisRateLimiter(int rate) {
        super(rate);
    }

    public boolean tryAcquire() {
        return tryAcquire(rate, 1000, TimeUnit.MILLISECONDS);
    }

    public boolean tryAcquire(int rate, int expireTime, TimeUnit timeUnit) {
        String key = "rate.limit";
        return tryAcquire(key, rate, 1000, TimeUnit.MILLISECONDS);

    }

    public boolean tryAcquire(String key, int rate, int expireTime, TimeUnit timeUnit) {
        Jedis jedis = jedisPool.getResource();
        List<String> keys = Collections.singletonList(key);
        int milliseconds = getMilliseconds(expireTime, timeUnit);
        List<String> argv = Arrays.asList(String.valueOf(rate), String.valueOf(milliseconds));
        Object eval = jedis.eval(LUA_SCRIPT, keys, argv);
        String result = String.valueOf(eval);
        jedis.close();
        return "1".equals(result);
    }

}
