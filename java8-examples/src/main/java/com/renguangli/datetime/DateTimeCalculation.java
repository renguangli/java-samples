package com.renguangli.datetime;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateTimeCalculation {

    /**
     * 时间计算
     */
    public void datetime() {

        // 1、计算日期差，
        LocalDate localDate = LocalDate.of(2017, 4, 3);
        Period period = Period.between(localDate, LocalDate.now());
        //int years = period.getYears(); // 两时间相差多少年
        //int months = period.getMonths(); // 两时间相差多少月
        //int days = period.getDays(); // 两时间相差多少天

        /*
         * 该方法仅支持，ChronoUnit.YEARS，ChronoUnit.MONTHS，ChronoUnit.DAYS三个单位
         * 如果不是三个单位将抛出UnsupportedTemporalTypeException
         */
        long years = period.get(ChronoUnit.YEARS);
        long months = period.get(ChronoUnit.MONTHS);
        long days = period.get(ChronoUnit.DAYS);
        System.out.println("两个时间相差" + years + "年" + months + "月" + days + "天"); //两个时间相差1年4月4天

        // 2、计算日期时间差，年月日时分秒毫秒那表
        LocalDateTime localDateTime = LocalDateTime.of(2017, Month.JANUARY, 1, 12, 12, 12);
        Duration duration = Duration.between(localDateTime, LocalDateTime.now());

        long between = ChronoUnit.MONTHS.between(localDateTime, LocalDateTime.now());
        System.out.println(between);
    }
}
