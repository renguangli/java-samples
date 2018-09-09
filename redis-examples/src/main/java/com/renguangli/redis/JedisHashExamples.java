package com.renguangli.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * jedis操作redis哈希数据类型
 * Created by renguangli at 2018/9/9 14:04
 * @since JDK1.8
 */
public class JedisHashExamples {

    private Jedis jedis;

    @Test
    public void objectEncoding() {
        jedis.hset("map", "a", "a");
        String map = jedis.objectEncoding("map");
        System.err.println(map);
    }

    @Test
    public void hstrlen() {
        jedis.hset("map", "a", "a");
        Long map = jedis.hlen("map");
        System.err.println(map);
    }

    @Test
    public void hvals() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        jedis.hmset("map", map);
        List<String> keys = jedis.hvals("map");
        keys.forEach(System.out::println);
    }

    @Test
    public void hkeys() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        jedis.hmset("map", map);
        Set<String> keys = jedis.hkeys("map");
        keys.forEach(System.out::println);
    }

    @Test
    public void hmsethmget() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        jedis.hmset("map", map);
        List<String> fields = jedis.hmget("map", "a", "b");
        fields.forEach(System.out::println);
    }

    @Test
    public void hexists() {
        jedis.hset("map", "a", "a");
        System.out.println(jedis.hexists("map", "a"));
        System.out.println(jedis.hexists("map", "b"));
    }

    @Test
    public void hdel() {
        jedis.hset("map", "a", "a");
        System.out.println(jedis.hget("map", "a"));
        jedis.hdel("map", "a");
        System.out.println(jedis.hget("map", "a"));

        jedis.hset("map", "a", "a");
        jedis.hset("map", "b", "b");
        System.out.println(jedis.hget("map", "a"));
        System.out.println(jedis.hget("map", "b"));

        jedis.hdel("map", "a", "b");
        System.out.println(jedis.hget("map", "a"));
        System.out.println(jedis.hget("map", "b"));
    }

    @Test
    public void hget() {
        jedis.hset("map", "a", "a");
        String a = jedis.hget("map", "a"); // 获取单个键
        System.out.println(a);

        Map<String, String> map = jedis.hgetAll("map");
        map.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
    }

    @Test
    public void hset() throws InterruptedException {
        Long hset = jedis.hset("map", "a", "a");
        Long hsetnx = jedis.hsetnx("map", "a", "a");
        System.out.println(hsetnx);
        System.out.println(hset);
        jedis.expire("map", 10);
        Long expire = 1L;
        do {
            Thread.sleep(500);
            expire = jedis.ttl("map");
            System.out.println(expire);
        } while (expire >= 0);
    }

    @Before
    public void setJedis() {
        jedis = JedisClient.getJedisPool().getResource();
    }

    @After
    public void close() {
        jedis.flushAll();
        jedis.close();
    }

}
