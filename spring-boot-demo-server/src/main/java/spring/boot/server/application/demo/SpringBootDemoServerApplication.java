package spring.boot.server.application.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import spring.boot.server.demo.config.SpringBootDemoServerApplicationConfiguration;

@Import(SpringBootDemoServerApplicationConfiguration.class)
@SpringBootApplication
public class SpringBootDemoServerApplication implements CommandLineRunner {
    /*
    Spring Boot之CommandLineRunner和ApplicationRunner
    (1）使用场景的提出；
       我们在开发过程中会有这样的场景：需要在容器启动的时候执行一些内容，比如：读取配置文件信息，数据库连接，删除临时文件，清除缓存信息，
       在Spring框架下是通过ApplicationListener监听器来实现的。在Spring Boot中给我们提供了两个接口来帮助我们实现这样的需求。这两个接口就是我们今天要讲的CommandLineRunner和ApplicationRunner，他们的执行时机为容器启动完成的时候。
    （2）共同点和区别；
    共同点：其一执行时机都是在容器启动完成的时候进行执行；其二这两个接口中都有一个run()方法；
    不同点：ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组。
    在实际项目开发中，我们会有在项目服务启动的时候就去加载一些数据或做一些事情这样的需求。
    为了解决这样的问题，Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现。
    很简单，只需要一个类就可以，无需其他配置。
    CommandLineRunner是一个接口，我们需要时，只需实现该接口就行。如果存在多个加载的数据，我们也可以使用@Order注解来排序。
     */

    // bean id 与@Bean name 相同
    @Autowired
    private DataSource masterDataSource;

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootDemoServerApplication.class);
        //a non-web application
        //springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);

        // 打印项目 java version
        System.out.println("Current Server Application Java Version : " + System.getProperty("java.version"));
        System.out.println("Current Server Application Java VM Version : " + System.getProperties().getProperty("java.vm.version"));
        System.out.println("Current Server Application Context : " + applicationContext);

    }

    // 实现CommandLineRunner 查看 Spring Boot 数据库连接池
    @Override
    public void run(String[] args) throws Exception {
        System.out.println("Current Server Application MasterDataSource : " + masterDataSource);
    }
}
