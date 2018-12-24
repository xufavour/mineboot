package com.nightstory.mineboot.common;

import org.slf4j.LoggerFactory;

/**
 * @Author: putao
 * @Date: 2018/11/27
 */
public class Log {

    public static boolean needLog = true;



    public static void d(String tag,String msg){
        if(!needLog) return;
        LoggerFactory.getLogger(tag).debug(msg);
    }

    public static void e(String tag,String msg){
        if(!needLog) return;
        LoggerFactory.getLogger(tag).error(msg);
    }

    public static void i(String tag,String msg){
        if(!needLog) return;
        LoggerFactory.getLogger(tag).info(msg);
    }
}
