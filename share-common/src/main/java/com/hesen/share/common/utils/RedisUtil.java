package com.hesen.share.common.utils;

import redis.clients.jedis.ShardedJedisPool;

/**
 * @Author: Hesen
 * @CreateDate: 2018/4/28 16:44
 */
public class RedisUtil {

    protected ShardedJedisPool jedisPool;

    public ShardedJedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(ShardedJedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
