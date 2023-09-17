package com.yoon;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * ApiApplication의 각종 Enable Annotation이 스프링테스트 진행 시 불필요한 mock을 발생하여 추가함
 */
@EnableAutoConfiguration
@SpringBootConfiguration
@Import({ ImdgConfig.class, RedisAutoConfiguration.class })
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
public class Config {
}
