package cn.zpf.cache;

import cn.zpf.Utils.SerializeUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * Created by LoseMyself
 * on 2017/3/16   9:26
 */
public class MybatisCache implements Cache {
    private static Logger logger = LoggerFactory.getLogger(MybatisCache.class);
    private Jedis redisClient = createRedis();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public MybatisCache(final String id){
        if(id == null){
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MybatisCache:id="+id);
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
        redisClient.set(SerializeUtil.serialize(key.toString()),SerializeUtil.serialize(value));
    }

    @Override
    public Object getObject(Object key) {
        Object value = SerializeUtil.unSerialize(redisClient.get(SerializeUtil.serialize(key.toString())));
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"="+value);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()),0);
    }

    @Override
    public void clear() {
        redisClient.flushDB();
    }

    @Override
    public int getSize() {
        return Integer.valueOf(redisClient.dbSize().toString());
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    protected static Jedis createRedis(){
        JedisPool pool = new JedisPool(new JedisPoolConfig(),"10.12.162.85");
        return pool.getResource();
    }
}
