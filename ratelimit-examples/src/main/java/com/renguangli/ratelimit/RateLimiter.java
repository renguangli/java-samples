package com.renguangli.ratelimit;

import java.util.concurrent.TimeUnit;

/**
 * ratelimit-examples
 * Created by renguangli at 2019/2/18 16:22
 *
 * @since JDK1.8
 */
public interface RateLimiter {

    boolean tryAcquire();

    boolean tryAcquire(int rate, int expireTime, TimeUnit timeUnit);

    boolean tryAcquire(String key, int rate, int expireTime, TimeUnit timeUnit);

}
