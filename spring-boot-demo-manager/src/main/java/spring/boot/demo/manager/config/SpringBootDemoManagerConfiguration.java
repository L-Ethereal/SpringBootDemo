package spring.boot.demo.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.boot.demo.manager.demo.HelloAction;
import spring.boot.demo.manager.demo.ManagerDemo;

@Configuration
public class SpringBootDemoManagerConfiguration {

    @Bean
    public ManagerDemo setManagerDemo () {
        return new ManagerDemo();
    }

    @Bean
    public HelloAction setHelloAction () {
        return new HelloAction();
    }
}
