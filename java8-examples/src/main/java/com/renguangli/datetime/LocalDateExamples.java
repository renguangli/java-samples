package com.renguangli.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * LocalDate 表示像 2018-08-08这样的日期。它包含有年份、月份、当月天数，不包含一天中的时间，以及时区信息。
 *
 * @author renguangli 2018/7/11 10:03
 * @since JDK 1.8
 */
public class LocalDateExamples {

    public static void main(String[] args) {

        //可以使用静态方法now()创建LocalDate
        LocalDate now = LocalDate.now();

        //可以使用静态方法of()创建LocalDate  2018-08-08
        LocalDate of = LocalDate.of(2018, 8, 8);

        //日期加法
        LocalDate now9 = now.plusDays(9);
        LocalDate localDate = now.plusMonths(2);
        System.out.println(localDate);

        System.out.println(now9);
        System.out.println(LocalDateTime.now().toString().replace("T", " "));

    }
}
