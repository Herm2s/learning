package com.hermes.others;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.FastDateFormat;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * @author herm2s
 * @since 2022/9/24 16:45
 */
class DateTest {

    @Test
    void dateTest() throws ParseException {
        FastDateFormat format = DatePattern.NORM_DATETIME_FORMAT;
        Date start = format.parse("2022-09-01 00:00:00");
        Date end = format.parse("2022-10-01 00:00:00");

        long leftTime = start.getTime();
        long rightTime = DateUtil.offsetDay(start, 6).getTime();
        long targetTime = new Date().getTime();
        while (rightTime < targetTime) {
            leftTime += 1000L * 60 * 60 * 24 * 7;
            rightTime += 1000L * 60 * 60 * 24 * 7;
        }
        System.out.println(format.format(leftTime) + " ~ " + format.format(rightTime));
    }

    @Test
    void dateTest1() throws ParseException {
        String sTime = "";
        String eTime = "";
        FastDateFormat format = DatePattern.NORM_DATETIME_FORMAT;
        Date nowDate = format.parse("2022-09-21 00:00:00");
        Date startTime = format.parse("2022-09-01 00:00:00");
        Date end = format.parse("2022-10-01 00:00:00");

        for (int i = 1; i < 1000; i++) {
            Date startDate = DateUtil.offsetDay(startTime, 7 * (i - 1));
            Date endDate = DateUtil.offsetDay(startTime, 7 * (i - 1) + 6);
            if (nowDate.getTime() <= endDate.getTime() && nowDate.getTime() >= startDate.getTime()) {
                sTime = format.format(startDate);
                eTime = format.format(endDate);
                break;
            }
        }
        System.out.println(sTime + " ~ " + eTime);
    }
}
