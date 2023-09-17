package com.yoon.redis;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;

@Profile("local")
@Configuration
@RequiredArgsConstructor
public class LocalRedisSetter {

    private final StringRedisTemplate stringRedisTemplate;

    @PostConstruct
    public void localDataSet(){
        stringRedisTemplate.opsForHash().put("productItem", "104", "30");
    }

}
