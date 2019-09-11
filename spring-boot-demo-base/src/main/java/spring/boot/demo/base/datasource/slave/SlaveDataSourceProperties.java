package spring.boot.demo.base.datasource.slave;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

// @Component的作用就是告诉spring， 我需要被注入到spring容器中，请按照我自身提供的参数来实例化一个类对象，并放入spring容器中
@Component
//@Getter
//@Setter
@Data
// @ConfigurationProperties注解的作用是将指定的配置文件映射到该类。也就是：配置文件值→同名类属性
@ConfigurationProperties(prefix = "hikari.datasource.slave")
// 指定读取配置文件 可以指定多个配置文件 用逗号隔开 忽略不存在的配置文件
@PropertySource( value = {"classpath:/config/datasource.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8", name = "datasource.properties")
public class SlaveDataSourceProperties {
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;
    private String type;
    private int hikariMinimumIdle;
    private boolean hikariAutoCommit;
    private long hikariConnectionTimeout;
    private String hikariConnectionTestQuery;
    private int maximumPoolSize;
    private String poolName;
    private long idleTimeout;
    private long maxLifetime;
    private boolean readOnly;
}
