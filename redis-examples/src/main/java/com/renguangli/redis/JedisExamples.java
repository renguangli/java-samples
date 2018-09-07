package com.renguangli.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.Semaphore;

/**
 * JedisExamples
 *
 * @author renguangli 2018/9/7 18:28
 * @since JDK 1.8
 */
public class JedisExamples {

    public static void main(String[] args) {
        final JedisPool jedisPool = new JedisPool("172.16.11.129");
        final Semaphore semaphore = new Semaphore(100);
        for (int i = 1000; i < 2000; i++) {
            new Thread(new Runnable() {
                public void run() {
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
                }
            }).start();
        }
    }

    static int  i = 1000;
    private synchronized static int getAndAdd() {
        return i ++;
    }
}
