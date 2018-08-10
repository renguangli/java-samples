package com.renguangli.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeExamples
 *
 * @author renguangli 2018/7/11 11:03
 * @since JDK 1.8
 */
public class LocalDateTimeExamples {

    public static void main(String[] args) {
        /*
         * LocalDateTime对象创建方式
         */
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = LocalDateTime.now(Clock.systemDefaultZone());
        dateTime = LocalDateTime.now(ZoneId.systemDefault());

        dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        dateTime = LocalDateTime.of(2018, 8, 8, 8, 3);
        dateTime = LocalDateTime.of(2018, 8, 8, 12, 53, 34, 88);

        LocalDateTime localDateTime = LocalDateTime.parse("2018-08-08T20:02:08.889");

        /*
         * LocalDateTime对象常用方法
         */
        int year = dateTime.getYear();
        int monthValue = dateTime.getMonthValue();
        int dayOfMonth = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();
        int nano = dateTime.getNano();

        //时间格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTime.format(formatter);

        // 时间加减运算
        dateTime.plusDays(1);
        dateTime.plusYears(1);
        dateTime.plusMonths(1);
        dateTime.plusHours(1);
        dateTime.plusMinutes(1);
        dateTime.plusSeconds(1);
        dateTime.plusNanos(1);

        dateTime.minusYears(1);
        dateTime.minusMonths(1);
        dateTime.minusDays(1);
        dateTime.minusHours(1);
        dateTime.minusMinutes(1);
        dateTime.minusSeconds(1);
        dateTime.minusNanos(1);

    }
}
