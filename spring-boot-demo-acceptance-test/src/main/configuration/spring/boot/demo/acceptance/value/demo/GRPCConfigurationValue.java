package spring.boot.demo.acceptance.value.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "grpc.server.demo")
// 读取指定 properties 文件 并且忽略不存在的文件
@PropertySource( value = {"classpath:/config/application.properties"}, ignoreResourceNotFound = true)
@Getter
@Setter
public class GRPCConfigurationValue {

    private String name;

    private int port;

}
