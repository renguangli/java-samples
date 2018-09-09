package com.renguangli.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/*
 * jedis操作redis通用命令
 * Created by renguangli at 2018/9/9 14:06
 * @since JDK1.8
 */
public class JedisGeneralExamples {

    private Jedis jedis;

    private JedisPool jedisPool = new JedisPool();

    @Test // expire添加过期时间以秒为单位 & ttl 查看过期时间以秒为单位
    public void expire() throws InterruptedException {
        jedis.set("expire", "expire");
        jedis.expire("expire", 10);

        Long expire = 1L;
        do {
            Thread.sleep(500);
            expire = jedis.pttl("expire");
            System.out.println(expire);
        } while (expire >= 0);

        /*
         * 键不存在返回 -2
         * 键没有过期时间返回 -1
         */
        jedis.set("jedis", "jedis");
        System.out.println(jedis.ttl("jedis"));
    }

    @Test // 键是否存在
    public void exists() {
        Boolean jedis = this.jedis.exists("jedis");
        System.out.println(jedis);
    }

    @Test // 获取键
    public void keys() {
        /*
         * ? 包含任何一个
         * * 包含 0 或多个
         * [key1,key2] 包含key1或 key2
         */
        jedis.set("a", "a");
        jedis.set("b", "b");
        jedis.set("c", "c");
        jedis.set("hello1", "hello1");
        jedis.set("hello2", "hello2");
        jedis.set("Hello", "hello");

        // Set<String> keys = jedis.keys("*");// 所有key
        //Set<String> keys = jedis.keys("h*");// 所有h开头的key, hello1,hello2
        // Set<String> keys = jedis.keys("?");// a,b,c
        // Set<String> keys = jedis.keys("hello?");// hello1,hello2
        //Set<String> keys = jedis.keys("hello[1,2]");// hello1,hello2
        Set<String> keys = jedis.keys("?*[1,2]");// hello1,hello2
        keys.forEach(System.out::println);
    }

    @Test // 当前库键个数
    public void dbSize() {
        Long dbSize = jedis.dbSize();
        System.out.println(dbSize);
    }

    @Before
    public void initJedis() {
        jedis = jedisPool.getResource();
    }

    @Test
    public void close() {
        jedis.flushDB();// 删除当前库所有键，阻塞
        jedis.flushAll();// 删除所有库所有键，阻塞
        jedis.close();
    }
}
