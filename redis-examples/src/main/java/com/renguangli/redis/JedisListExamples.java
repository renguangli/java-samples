package com.renguangli.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.ListPosition;

/**
 * JedisListExamples
 *
 * @author renguangli 2018/9/11 9:26
 * @since JDK 1.8
 */
public class JedisListExamples {

    private Jedis jedis;

    @Test
    public void rpush() {
        jedis.rpush("list", "a", "b", "c", "d");
        // 获取列表长度
        System.out.println(jedis.llen("list"));
        // 获取指定索引处的值
        System.out.println(jedis.lindex("list", 0));
        // 在列表中的另一个元素之前或之后插入一个元素
        jedis.linsert("list", ListPosition.BEFORE, "a", "A");
        jedis.linsert("list", ListPosition.AFTER, "a", "B");
        System.out.println(jedis.lindex("list", 0));
        System.out.println(jedis.lindex("list", 2));


    }

    @Before
    public void initJedis() {
        jedis = JedisClient.getJedis();
    }

    @After
    public void destroy() {
        jedis.flushDB();
        jedis.flushAll();
        jedis.close();
    }


}
