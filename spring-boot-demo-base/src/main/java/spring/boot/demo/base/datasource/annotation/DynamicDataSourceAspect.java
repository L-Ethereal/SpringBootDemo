package spring.boot.demo.base.datasource.annotation;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import spring.boot.demo.base.datasource.dynamic.DynamicDataSourceHolder;

/**
 * 动态数据源AOP切面定义
 */
@Component
@Aspect
@Slf4j
public class DynamicDataSourceAspect {
    //切换放在mapper接口的方法上，所以这里要配置AOP切面的切入点
//    @Pointcut("execution( * spring.boot.demo.dao.mapper.demo.*.*(..) || * spring.boot.demo.manager.demo.*.*(..) )")
    @Pointcut( "execution( * spring.boot.demo.manager.demo.*.*(..) )")
    public void dataSourcePointCut() {
    }

    @Before("dataSourcePointCut()")
    public void before(JoinPoint joinPoint) {
        // joinpoint.getArgs();//輸入的參數列表
        // joinpoint.getTarget().getClass().getName();// 类全路径
        // joinpoint.getSignature().getDeclaringTypeName();//接口全路径
        // joinpoint.getSignature().getName();//调用的方法
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        log.info("JoinPoint signature name is : " + method);
        Class<?>[] clazz = target.getClass().getInterfaces();
        Class<?> targetClass = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {
//            Method m = clazz[0].getMethod(method, parameterTypes);
            Method m = targetClass.getMethod(method, parameterTypes);
            //如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
            if (m != null && m.isAnnotationPresent(DynamicDataSource.class)) {
                DynamicDataSource data = m.getAnnotation(DynamicDataSource.class);
                String dataSourceName = data.dataSource();
                DynamicDataSourceHolder.setDataSource(dataSourceName);
                log.debug("current thread " + Thread.currentThread().getName() + " add " + dataSourceName + " to ThreadLocal");
            } else {
                log.debug("switch datasource fail,use default");
            }
        } catch (Exception e) {
            log.error("current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error", e);
            throw new RuntimeException(e);
        }
    }

    //执行完切面后，将线程共享中的数据源名称清空
    @After("dataSourcePointCut()")
    public void after(JoinPoint joinPoint){
        DynamicDataSourceHolder.removeDataSource();
    }
}
