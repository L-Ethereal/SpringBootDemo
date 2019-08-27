package spring.boot.demo.acceptance.configuration.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Configuration 的加载时机高于 bean
@Configuration
// 读取指定 properties 文件 并且忽略不存在的文件
//@PropertySource( value = {"classpath:/config/application.properties"}, ignoreResourceNotFound = true)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootDemoAcceptanceConfiguration {

    /*
        关于 classpath
        src 不是 classpath
        classpath是在编译后文件存放路径，默认是的bulid/classes/
        lib 和 classes 同属classpath 两者访问的优先级为 lib>classes
     */

    private final static Logger logger = LoggerFactory.getLogger(SpringBootDemoAcceptanceConfiguration.class);

    public SpringBootDemoAcceptanceConfiguration () {
        System.out.println("Start SpringBootDemoAcceptanceConfiguration");
    }
}
