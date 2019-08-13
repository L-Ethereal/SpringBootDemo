package spring.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import spring.boot.config.SpringBootServiceApplicationConfiguration;

@Import(SpringBootServiceApplicationConfiguration.class)
@SpringBootApplication
public class SpringBootServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootServiceApplication.class);
        //a non-web application
        //springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);

        System.out.println("服务启动成功****=====***** : " + applicationContext);

    }
}
