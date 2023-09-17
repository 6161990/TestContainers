package com.yoon.redis;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "stock", timeToLive = 100)
@AllArgsConstructor
public class StockRedisEntity {
    @Id
    private String id;
    private Long stock;
}
