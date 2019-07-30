package com.nightstory.mineboot.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: putao
 * @Date: 2019/4/13
 */
public abstract class RedisConfig {

    private static final String host = "r-bp1bb2b5c0e0aba4800.redis.rds.aliyuncs.com";
    private static final int port = 6379;
    private static final String password = "Ecook123456";

    /**
     * maxTotal: 资源池中的最大连接数
     * maxIdle: 资源池允许的最大空闲连接数
     * minIdle: 资源池确保的最少空闲连接数
     * timeout: 既是连接超时又是读写超时
     * blockWhenExhausted: 当资源池用尽后，调用者是否要等待。只有当值为 true 时，下面的 maxWaitMillis 才会生效。 默认true
     * maxWaitMillis: 当资源池连接用尽后，调用者的最大等待时间（单位为毫秒）
     * DB:用于切换到指定的数据库，数据库索引号 index 用数字值指定，以 0 作为起始索引值。 默认0
     */

    private static final int maxTotal = 8;
    private static int maxIdle = 8;
    private static int minIdle = 0;
    private static int timeout = 10 * 000;
    private static int maxWaitMillis = 10 * 1000;


    protected static int DB = 22;
    protected static JedisPool jedisPool;


    /**
     * 初始化及资源池配置
     * Jedis 使用 Apache Commons-pool2 对资源池进行管理,JedisPoolConfig只是对Commons-pool2做了一些默认参数配置
     */
    static {
        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(maxTotal);
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMinIdle(minIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * get value 指令
     * @param key
     * @return
     */
    public static String orderGet(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            return jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return null;
    }

    /**
     * del key[key...] 指令 O(N) n为key数量
     * @param keys
     * @return
     */
    public static boolean orderDel(String... keys){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            Long del = jedis.del(keys);
            if(del.equals(0L)){
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return true;
    }

    /**
     * exist key 指令
     * @param key
     * @return
     */
    public static boolean orderExist(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            return jedis.exists(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return false;
    }


    /**
     * expire key seconds 指令
     * @param key
     * @param timeout
     * @return
     */
    public static long orderExpire(String key,int timeout){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            return jedis.expire(key, timeout);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return 0;
    }

    /**
     *  set key value 指令 总是返回ok, 默认永不超时
     * @param key
     * @param value
     * @return
     */
    public static boolean orderSet(String key,String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            jedis.set(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return true;
    }


    /**
     * set key value nx/xx ex/px timout 指令方法
     * @param key
     * @param value
     * @param nxxx nx: 不存在key时才设置. xx: 存在时才设置
     * @param expx ex: 表示timeou单位为秒. px: 单位为毫秒
     * @param timeout
     * @return
     */
    public static String orderSet(String key,String value,String nxxx,String expx,int timeout){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            return jedis.set(key, value, nxxx, expx, timeout);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return null;
    }

    /**
     * set key value nx/xx 指令方法
     * @param key
     * @param value
     * @param nxxx
     * @return
     */
    public static String orderSet(String key,String value,String nxxx){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            return jedis.set(key, value, nxxx);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return null;
    }


    /**
     * setnx key value 指令
     * 因为 SET 命令可以通过参数来实现 SETNX 、 SETEX 以及 PSETEX 命令的效果，
     * 所以 Redis 将来的版本可能会移除并废弃 SETNX 、 SETEX 和 PSETEX 这三个命令.
     * @param key
     * @param value
     * @return
     */
    @Deprecated
    public static boolean orderSetnx(String key,String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(DB);
            jedis.setnx(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return true;
    }



    /**
     * 资源释放
     * @param jedis
     */
    protected static void close(Jedis jedis){
        if(jedis != null && jedisPool != null){
            jedis.close();
        }
    }
}
