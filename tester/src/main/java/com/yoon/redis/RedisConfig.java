package com.yoon.redis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories(basePackages = "com.yoon")
@Configuration
@ComponentScan(basePackageClasses = RedisConfig.class)
public class RedisConfig {


}
