package com.renguangli.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * jedis操作通用命令
 *
 * @author renguangli 2018/9/7 18:28
 * @since JDK 1.8
 */
public class JedisExamples {

    private static String keyPrefix = "vcode:phone:";

    private static Jedis jedis;

    private static JedisPool jedisPool = new JedisPool();

    public static void main(String[] args) {
        final JedisPool jedisPool = new JedisPool();
        final Semaphore semaphore = new Semaphore(100);
        for (int i = 1000; i < 2000; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    int a = getAndAdd();
                    Jedis jedis = jedisPool.getResource();
                    jedis.set("a" + a, "a" + a);
                    jedis.close();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    static int  i = 1000;
    private synchronized static int getAndAdd() {
        return i ++;
    }

    @Test
    public void publish() {
        jedis.publish("channel:chat", "aaa");
    }

    @Test
    public void str() {
        Long hello = jedis.strlen("hello");
        System.out.println(hello);
        jedis.append("hello", "ddd");
        System.out.println(jedis.get("hello"));
        System.out.println(jedis.getrange("hello", 0 , 1));
    }

    @Test
    public void getVcode() {
        String telNo = "17600902030";
        String key = keyPrefix + telNo;
        String vcode = jedis.get(key);
        if (vcode == null) {
            System.out.println("发送短信获取手机验证码！");
            jedis.setex(key, 60, "1234");
        } else {
            System.out.println("60秒内只获取一个验证码！");
        }

    }

    @Test
    public void set() {
        String set = jedis.set("hello", "world");
        System.out.println(set);
        System.out.println(jedis.get("hello"));

        jedis.set("ab", "a", "nx", "ex", 10);
        Long a = jedis.ttl("ab");
        System.out.println(a);
    }

    @Test
    public void keys() {
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
        jedis.close();
    }

    @Test
    public void dbsize() {
        long dbSize = jedis.dbSize();
        System.out.println(dbSize);
    }

    @Before
    public void getJedis() {
        jedis = jedisPool.getResource();
    }

    @After
    public void close() {
        jedis.close();
    }
}
