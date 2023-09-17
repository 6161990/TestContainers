package com.yoon;

import io.lettuce.core.StrAlgoArgs;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Profile("local")
@Configuration
@RequiredArgsConstructor
public class LocalRedisSetter {

    private final RedisTemplate<Byte[], Byte[]> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    @PostConstruct
    public void localDataSet(){
        stringRedisTemplate.opsForValue().set("productItem:111", "30");
    }

}
