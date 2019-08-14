package spring.boot.server.application.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import spring.boot.server.demo.config.SpringBootDemoServerApplicationConfiguration;


@Import(SpringBootDemoServerApplicationConfiguration.class)
@SpringBootApplication
public class SpringBootDemoServerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootDemoServerApplication.class);
        //a non-web application
        //springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);

        System.out.println("Current Server Application Context : " + applicationContext);

    }
}
