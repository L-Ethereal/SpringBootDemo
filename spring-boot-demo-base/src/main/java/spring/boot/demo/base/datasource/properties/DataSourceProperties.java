package spring.boot.demo.base.datasource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
// @ConfigurationProperties注解的作用是将指定的配置文件映射到该类。也就是：配置文件值→同名类属性
@ConfigurationProperties(prefix = "hikari")
// 指定读取配置文件 可以指定多个配置文件 用逗号隔开 忽略不存在的配置文件
@PropertySource( value = {"classpath:/config/datasource.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8", name = "datasource.properties")
public class DataSourceProperties {

//    private HikariDataSource master;
//    private HikariDataSource slave;

}
