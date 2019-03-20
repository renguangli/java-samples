package com.renguangli.ratelimit;

import java.util.concurrent.TimeUnit;

/**
 * ratelimit-examples
 * Created by renguangli at 2019/2/18 16:30
 *
 * @since JDK1.8
 */
public class RateLimiterExamples {

    private static RateLimiter rateLimiter = new RedisRateLimiter();

    private static String key = "rate.limit:ip:";

    public static boolean sendMsg() {
        String redisKey = key + "192.168.10.11";
        if (rateLimiter.tryAcquire(redisKey, 10, 1, TimeUnit.SECONDS)) {
            System.out.println("信息发送成功！");
            return true;
        }
        System.out.println("信息发送失败，每秒只能发送10次！");
        return false;
    }

}
