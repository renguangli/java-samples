package com.renguangli.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * InstantExamples
 *
 * @author renguangli 2018/7/11 10:17
 * @since JDK 1.8
 */
public class InstantExamples {

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();

        TimeUnit.HOURS.sleep(2);

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        long l = duration.toHours();
        System.out.println(l);

    }
}
