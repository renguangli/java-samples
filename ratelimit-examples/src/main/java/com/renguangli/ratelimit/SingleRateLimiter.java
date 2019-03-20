package com.renguangli.ratelimit;

import java.util.concurrent.TimeUnit;

/**
 * ratelimit-examples
 * Created by renguangli at 2019/2/18 16:26
 *
 * @since JDK1.8
 */
public class SingleRateLimiter extends AbstractRateLimiter {

    private int count;

    private long lastTime;

    public SingleRateLimiter() {
        super();
    }

    public SingleRateLimiter(int rate) {
        super(rate);
    }

    public boolean tryAcquire() {
        return tryAcquire(this.rate, 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean tryAcquire(int rate, int expireTime, TimeUnit timeUnit) {
        return tryAcquire(null, rate, expireTime, timeUnit);
    }

    @Override
    public synchronized boolean tryAcquire(String key, int rate, int expireTime, TimeUnit timeUnit) {
        int milliseconds = getMilliseconds(expireTime, timeUnit);
        if (milliseconds + lastTime <= System.currentTimeMillis()) {
            count = 0;
            lastTime = System.currentTimeMillis();
        }
        return ++ count <= rate;
    }

}
