package spring.boot.demo.base.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import spring.boot.demo.base.support.util.Const;

/**
 * 目标数据源注解，注解在方法上指定数据源的名称
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DynamicDataSource {
    String dataSource() default Const.DATASOURCE_MASTER; //此处接收的是数据源的名称
}
