package srping.boot.demo.service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"spring.boot.demo.dao"})
public class SpringBootDemoServiceConfiguration {
    /*
    spring @MapperScan和@ComponentScan的区别
    @MapperScan和@ComponentScan都是扫描包
    @ComponentScan是组件扫描注解，用来扫描@Controller  @Service  @Repository这类,主要就是定义扫描的路径从中找出标志了需要装配的类到Spring容器中
    @MapperScan 是扫描mapper类的注解,就不用在每个mapper类上加@MapperScan了
    这两个注解是可以同时使用的。

    上面由于要扫描 Mapper 所以应该用 @MapperScan 用 @ComponentScan 的话 会扫描不到
     */
}
