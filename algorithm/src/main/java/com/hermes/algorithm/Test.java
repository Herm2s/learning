package com.hermes.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * @author liu.zongbin
 * @date 2024/3/8
 */
public class Test {

    /**
     * 已知，纽约时间比北京时间慢12小时，请根据用户输入的北京时间输出相应的纽约时间，若用户输入错误的月份或日期等信息则将其顺加。
     * 例如用户输入2021 13 32 14 43 54则生成北京时间为：2022-02-01 14:43:54 纽约时间为：2022-02-01 02:43:54
     * <p>
     * 输入描述
     * 一组字符串，年，月，日，时，分，秒用空格隔开，如果用户数据输入不正常，应输出“您输入的数据不合理”
     * <p>
     * 输出描述  2 4 6 9 11
     * 北京时间为：年-月-日 时:分:秒
     * 纽约时间为：年-月-日 时:分:秒
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MM dd HH mm ss");
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();

        //write your code here......
        try {
            Date parse = sdf1.parse(str1);
            String[] split = str1.split(" ");
            int year = Integer.valueOf(split[0]);
            int month = Integer.valueOf(split[1]);
            int day = Integer.valueOf(split[2]);
            int hour = Integer.valueOf(split[3]);
            int minute = Integer.valueOf(split[4]);
            int second = Integer.valueOf(split[5]);
            if (day > 31) {
                if (month == 1 || month == 3 || month == 5 || month == 7 | month == 8 || month == 10 || month == 12||month==13) {
                    day = day % 31;
                } else if (month == 2) {
                    day = day % 28;
                } else {
                    day = day % 30;
                }
                month++;
            }
            year += month == 12 ? 0 : month / 12;
            if (month > 12) {
                month = month % 12;
            }

            LocalDateTime beijing = LocalDateTime.of(year, month, day, hour, minute, second);
            String result = beijing.plusHours(-12L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("北京时间为：" + beijing.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println("纽约时间为：" + result);
        } catch (ParseException e) {
            System.out.println("您输入的数据不合理");
        }
    }
}
