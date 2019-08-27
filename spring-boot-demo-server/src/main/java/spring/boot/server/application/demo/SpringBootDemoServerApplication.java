package spring.boot.server.application.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import spring.boot.server.demo.config.SpringBootDemoServerApplicationConfiguration;

@Import(SpringBootDemoServerApplicationConfiguration.class)
@SpringBootApplication
public class SpringBootDemoServerApplication {

//    @Autowired
//    private static GrpcLauncher grpcLauncher;

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootDemoServerApplication.class);
        //a non-web application
        //springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);

//        Map<String, Object> grpcServiceBeanMap =  applicationContext.getBeansWithAnnotation(GrpcService.class);
//        GrpcLauncher grpcLauncher = applicationContext.getBean("GrpcLauncher",GrpcLauncher.class);
//        grpcLauncher.grpcStart(grpcServiceBeanMap);

        System.out.println("Current Server Application Context : " + applicationContext);

    }
}
