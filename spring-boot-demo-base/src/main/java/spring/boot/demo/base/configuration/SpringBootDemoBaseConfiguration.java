package spring.boot.demo.base.configuration;

import org.springframework.context.annotation.Import;

@Import({DataSourceConfiguration.class, MybatisConfiguration.class})
public class SpringBootDemoBaseConfiguration {
}
