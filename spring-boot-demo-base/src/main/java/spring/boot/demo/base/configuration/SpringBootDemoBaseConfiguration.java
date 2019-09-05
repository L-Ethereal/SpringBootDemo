package spring.boot.demo.base.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Import;

@Import(DataSourceConfiguration.class)
public class SpringBootDemoBaseConfiguration {
}
