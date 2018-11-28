package com.renguangli.jodatime;

import org.joda.time.DateTime;

/**
 * JodetimeExamples
 *
 * @author renguangli 2018/11/28 16:47
 * @since JDK 1.8
 */
class JodatimeExamples {
    public static void main(String[] args) {
    }

    /**
     * 本月剩余毫秒数
     * @return
     */
    private long getMillisOfMonth() {
        DateTime now = new DateTime();
        DateTime dt = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0,  0, 0, 0);
        DateTime dateTime = dt.withDayOfMonth(1);
        long millis = dateTime.getMillis();
        return 60 * 60 * 24 * 30 * 1000L - (now.getMillis() - millis);
    }

    /**
     * 本周剩余毫秒数
     * @return
     */
    private long getMillisOfWeek() {
        DateTime now = new DateTime();
        DateTime dt = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0,  0, 0, 0);
        DateTime dateTime = dt.withDayOfWeek(1);
        long millis = dateTime.getMillis();
        return 60 * 60 * 24 * 7 * 1000 - (now.getMillis() - millis);
    }

    /**
     * 当天剩余毫秒数
     * @return
     */
    private long millisOfDay() {
        DateTime now = new DateTime();
        DateTime dateTime = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0,  0, 0, 0);
        long millis = dateTime.getMillis();
        return 60 * 60 * 24 - (now.getMillis() - millis);
    }
}
