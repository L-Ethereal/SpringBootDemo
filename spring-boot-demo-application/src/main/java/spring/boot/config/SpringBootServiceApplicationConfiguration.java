package spring.boot.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import srping.boot.demo.service.config.SpringBootDemoServiceConfiguration;

@Configuration
@Import(SpringBootDemoServiceConfiguration.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootServiceApplicationConfiguration {
    /*
    @EnableAutoConfiguration
    Spring Boot会自动根据你jar包的依赖来自动配置项目。
    例如当你项目下面有HSQLDB的依赖时，Spring Boot会创建默认的内存数据库的数据源DataSource，如果你自己创建了DataSource，
    Spring Boot就不会创建默认的DataSource。
    个人理解： 如果你用了Mybatis，它的配置文件中会指定 数据库相关的参数，这个时候就用
    exclude={DataSourceAutoConfiguration.class}, 让spring-boot不要根据Maven中依赖自动配置了。
     */
}
