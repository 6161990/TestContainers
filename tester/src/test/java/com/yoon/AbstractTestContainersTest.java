package com.yoon;

import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Tag("integration")
@Testcontainers
@TestConfiguration(proxyBeanMethods = false)
/*
 * @TestConfiguration 의 일반적인 사용 사례는 테스트에서만 필요한 빈을 정의하는 데 사용되며,
 * proxyBeanMethods 속성을 false 로 설정하여 매번 새로운 빈을 생성하도록 지정할 때 유용합니다.
 * 이렇게 하면 각각의 테스트가 독립적으로 작동하며 서로의 상태에 영향을 주지 않습니다.
 */
public abstract class AbstractTestContainersTest {

    @Container
    @ServiceConnection("redis")
    static GenericContainer<?> redisContainer = new GenericContainer<>(DockerImageName.parse("redis:7.0"))
            .withExposedPorts(6379);

    @DynamicPropertySource
    static void redisResistry(DynamicPropertyRegistry registry){
        registry.add("spring.data.redis.host", redisContainer::getHost);
        registry.add("spring.data.redis.port", redisContainer::getFirstMappedPort);
    }


}
