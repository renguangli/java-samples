package com.renguangli.ratelimit;

import java.util.concurrent.TimeUnit;

/**
 * ratelimit-examples
 * Created by renguangli at 2019/2/18 16:23
 *
 * @since JDK1.8
 */
public abstract class AbstractRateLimiter implements RateLimiter {

    protected int rate;

    public AbstractRateLimiter() {
        this.rate = 10;
    }

    public AbstractRateLimiter(int rate) {
        this.rate = rate;
    }

    protected int getMilliseconds(int time, TimeUnit timeUnit){
        if (TimeUnit.MICROSECONDS == timeUnit) {
            time /= 1000;
        } else if (TimeUnit.SECONDS == timeUnit) {
            time *= 1000;
        } else if (TimeUnit.MINUTES == timeUnit) {
            time *= 1000 * 60;
        }
        return time;
    }

}
