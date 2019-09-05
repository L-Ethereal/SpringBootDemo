package spring.boot.demo.acceptance.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import spring.boot.demo.acceptance.configuration.SpringBootDemoAcceptanceConfiguration;


@Import(SpringBootDemoAcceptanceConfiguration.class)
//@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootDemoAcceptanceServerApplication {
    public static void main(String[] args) throws Exception {
        // 打印项目 java version
        System.getProperties().getProperty("java.vm.version");
        System.out.println("Start SpringBootDemoAcceptanceServerApplication");
    }
}
