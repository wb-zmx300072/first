package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/3/19 12:50
 */
public class RedisPoolUtil {
    private  static final Logger logger = LoggerFactory.getLogger(RedisPoolUtil.class);
    private JedisPool pool;

    private static int LOGIN_DISTORY_TIME = 60*30;
    @Resource
    public JedisPoolConfig config;

    public void init() {
        pool = new JedisPool(config, PropertiesUtil.getProperty("cache.redis.servers"), Integer.parseInt(PropertiesUtil.getProperty("cache.redis.port")), 4000);
    }

    public Jedis getInstance() {
        return pool.getResource();
    }

    public void returnResource(Jedis jedis) {
        pool.returnResource(jedis);
    }

    public void returnBrokenResource(Jedis jedis){
        pool.returnBrokenResource(jedis);
    }

    public Jedis getJedis() {
        return getInstance();
    }

    public void releaseJedis(Jedis jedis) {
        returnResource(jedis);
    }

    public void releaseBrokenJedis(Jedis jedis) {
        returnBrokenResource(jedis);
    }

    /**String
     * 通过key获取储存在redis中的value
     * 并释放连接
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            releaseBrokenJedis(jedis);
//            e.printStackTrace();
        } finally {
            releaseJedis(jedis);
        }
        return result;
    }
    /**
     * <p>
     * 设置key value,如果key已经存在则返回0,nx==> not exist
     * @param key
     * @param value
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long setnx(String key, String value) {
        Jedis jedis = null;
        Long result = 0L;
        try {
            jedis = getJedis();
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            releaseBrokenJedis(jedis);
            logger.error(" RedisPoolUtil setnx error key:{},value:{}",new Object[]{key,value },e);
        } finally {
            releaseJedis(jedis);
        }

        return result;
    }
    /**
     * <p>
     * 设置key value,如果key已经存在则返回0,nx==> not exist
     * @param key
     * @param value
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public String setex(String key,int secound, String value) {
        Jedis jedis = null;
        String result = "";
        try {
            jedis = getJedis();
            result = jedis.setex(key,secound,value);
        } catch (Exception e) {
            releaseBrokenJedis(jedis);
            logger.error(" RedisPoolUtil setex error key:{},secound:{},value:{}",new Object[]{key,secound,value },e);
        } finally {
            releaseJedis(jedis);
        }

        return result;
    }

    /**
     * <p>
     * 设置失效时间
     * @param key
     * @return
     */
    public Long expire(String key,int secound) {
        Jedis jedis = null;
        Long result = 0L;
        try {
            jedis = getJedis();
            result = jedis.expire(key,secound);
        } catch (Exception e) {
            releaseBrokenJedis(jedis);
            logger.error(" RedisPoolUtil expire error key:{},secound:{}",new Object[]{key,secound },e);
        } finally {
            releaseJedis(jedis);
        }
        return result;
    }




}
