package com.nightstory.mineboot.common;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @Author: putao
 * @Date: 2018/12/18
 */
public class LocalDateTimeUtils {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
//        Student student = new Student("12","d");

    }

    /**
     * 获取默认时区
     * @return
     */
    public static String getTimeZone(){
        ZoneId zone = ZoneId.systemDefault();
        return zone.toString();
    }


    public static String lastDaysDate(int n){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        LocalDateTime yestedayDate = localDateTime.minusDays(n);
        return yestedayDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
