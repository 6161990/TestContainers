package com.yoon.redis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataRedisTest
public class StockAdapterTest extends AbstractTestContainersTest{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private StockRedisRepository stockRedisRepository;

    @BeforeEach
    public void setUp(){
        stringRedisTemplate.opsForHash().put("productItem", "104", "30");
        stringRedisTemplate.opsForHash().put("productItem", "101", "30");
        stockRedisRepository.save(new StockRedisEntity("104", 30L));
    }

    @Test
    void name() {
        List<Object> result = stringRedisTemplate.opsForHash().multiGet("productItem", Arrays.asList("101", "104", "empty"));

        assertThat(result).containsExactly("30", "30", null);
    }
}
