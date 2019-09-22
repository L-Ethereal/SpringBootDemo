package spring.boot.demo.data.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Component
// @ConfigurationProperties和@Value
@ConfigurationProperties(prefix = "spring.data.redis")
@PropertySource( value = {"classpath:/config/springdata.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8", name = "springdata.properties")
public class SpringDataRedisProperties {
    // redis 配置
    private int database;
    private String host;
    private int port;
    private String password;
    private int timeout;

    // jedis pool连接池配置
    private int jedisPoolMaxActive;
    private int jedisPoolMaxWait;
    private int jedisPoolMaxIdle;
    private int jedisPoolMinIdle;
}
