package com.yoon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories(basePackages = "com.yoon")
@Configuration
@ComponentScan(basePackageClasses = ImdgConfig.class)
public class ImdgConfig {

    @Bean
    public RedisTemplate<Byte[], Byte[]> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Byte[], Byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
