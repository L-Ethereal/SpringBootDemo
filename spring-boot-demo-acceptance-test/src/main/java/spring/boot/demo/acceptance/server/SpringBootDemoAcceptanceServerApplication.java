package spring.boot.demo.acceptance.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import spring.boot.demo.acceptance.configuration.demo.SpringBootDemoAcceptanceConfiguration;

@Import(SpringBootDemoAcceptanceConfiguration.class)
//@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootDemoAcceptanceServerApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("Start SpringBootDemoAcceptanceServerApplication");
    }
}
