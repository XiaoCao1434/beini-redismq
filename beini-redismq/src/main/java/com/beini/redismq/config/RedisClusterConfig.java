package com.beini.redismq.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
@Configuration
public class RedisClusterConfig {
    /**
     * 注意：
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return
     */
    @Bean("myCluster")
    public JedisCluster getJedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("127.0.0.1",7001));
        nodes.add(new HostAndPort("127.0.0.1",7000));
        nodes.add(new HostAndPort("127.0.0.1",7002));
        return new JedisCluster(nodes,1800);
    }
}
