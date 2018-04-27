package com.beini.redismq.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisCluster;

@Component
public class RedisClusterUtil {
	@Resource(name="myCluster")
	private JedisCluster jedisCluster;
	
	public void lPush(String key, String value) {
        jedisCluster.lpush(key, value);
    }
	
	public void set(String key, String value) {
        jedisCluster.set(key, value);
    }
	
	public void rPop(String key) {
		jedisCluster.rpop(key);
	}
}
