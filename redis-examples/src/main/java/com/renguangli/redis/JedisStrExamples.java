package com.renguangli.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;


/**
 * jedis操作redis字符串命令
 *
 * @author renguangli 2018/9/7 18:28
 * @since JDK 1.8
 */
public class JedisStrExamples {

    private Jedis jedis;

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
        String key = "vcode:telNo:17600902030";
        String vcode = jedis.get(key);
        if (vcode == null) {
            System.out.println("发送短信获取手机验证码！");
            jedis.setex(key, 600, "1234");
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

    @Before
    public void getJedis() {
        jedis = JedisClient.getJedis();
    }

    @After
    public void close() {
        jedis.close();
    }

}
