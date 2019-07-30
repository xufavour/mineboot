package com.nightstory.mineboot.common.redis;

/**
 * @Author: putao
 * @Date: 2019/4/13
 */
public class JedisUtil extends RedisConfig{



    public static String get(String key){
        return orderGet(key);
    }

    /**
     * 无超时
     */
    public static boolean set(String key,String value){
        return orderSet(key, value);
    }

    /**
     * 只有key不存在时才设置并返回true,并设置超时时间,可用于分布式锁
     * @param key
     * @param value
     * @param timeout
     * @return
     */
    public static boolean setnx(String key,String value,int timeout){
        String result = orderSet(key, value, "nx", "ex", timeout);
        if(result == null || !result.equals("OK")){
            return false;
        }
        return true;
    }
    /**
     * 只有key存在时才设置返回true,并设置超时时间,可用于分布式锁
     * @param key
     * @param value
     * @param timeout
     * @return
     */
    public static boolean setxx(String key,String value,int timeout){
        String result = orderSet(key, value, "xx", "ex", timeout);
        if(result == null || !result.equals("OK")){
            return false;
        }
        return true;
    }











}
