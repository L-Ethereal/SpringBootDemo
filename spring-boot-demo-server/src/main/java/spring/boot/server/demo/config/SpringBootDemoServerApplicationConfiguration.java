package spring.boot.server.demo.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;
import spring.boot.demo.base.configuration.DataSourceConfiguration;
import spring.boot.demo.manager.config.SpringBootDemoManagerConfiguration;
import srping.boot.demo.service.config.SpringBootDemoServiceConfiguration;

@Configuration
@Slf4j
@Import({SpringBootDemoServiceConfiguration.class, SpringBootDemoManagerConfiguration.class, DataSourceConfiguration.class})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootDemoServerApplicationConfiguration implements ApplicationContextAware, InitializingBean {
    /*
    @EnableAutoConfiguration
    Spring Boot会自动根据你jar包的依赖来自动配置项目。
    例如当你项目下面有HSQLDB的依赖时，Spring Boot会创建默认的内存数据库的数据源DataSource，如果你自己创建了DataSource，
    Spring Boot就不会创建默认的DataSource。
    个人理解： 如果你用了Mybatis，它的配置文件中会指定 数据库相关的参数，这个时候就用
    exclude={DataSourceAutoConfiguration.class}, 让spring-boot不要根据Maven中依赖自动配置了。
     */

    private ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
//        Reflections reflections = new Reflections("cn.mccreefei.technologystack.rpc.api");
//        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(RpcProxy.class);
//        if (!CollectionUtils.isEmpty(typesAnnotatedWith)){
//            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
//            typesAnnotatedWith.forEach(cls -> {
//                RpcProxy annotation = cls.getAnnotation(RpcProxy.class);
//                if (annotation.proxyTargetClass()){
//                    beanFactory.registerSingleton(cls.getName(), proxyFactory.createInstance(cls, true));
//                }else {
//                    beanFactory.registerSingleton(cls.getName(), proxyFactory.createInstance(cls, false));
//                }
//            });
//        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
