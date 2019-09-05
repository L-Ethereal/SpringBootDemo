package spring.boot.demo.base.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;
import spring.boot.demo.base.datasource.master.MasterDataSourceConfiguration;

/**
 * HikariCP连接池配置
 */
@Slf4j
@Configuration
/*
    @Configuration 中使用 @Autowired 标红的问题
    在 Spring Boot 项目中会用 @Configuration 注解来初始化配置, 这时可以通过 @autowired 自动注入封装好的model对象, 方便使用properties中的配置的数据。
    这样做代码运行没问题，通过该对象也可以成功的获取properties配置文件中的数据，
    但是 IDE 却给出 “Could not autowird. No beans of'masterDataSourceConfiguration' type found.” 的错误提示。

    我们手动的在 @Configuration 注解下面添加 @ComponentScan 注解并指定所需model类的包地址就可以解决整个问题了。
    原因估计是因为在项目的启动的最初阶段，IDE 还没有扫描到model类，无法发现对应的 bean ，于是就需要我们手动的给其指定需要扫描的包了。
 */
@ComponentScan(basePackages = {"spring.boot.demo.base.datasource"})
public class DataSourceConfiguration {

    /*
    Mybatis 和 JDBC 区别
    JDBC是Java提供的一个操作数据库的API；
    MyBatis是一个支持普通SQL查询，存储过程和高级映射的优秀持久层框架。MyBatis消除了几乎所有的JDBC代码和参数的手工设置以及对结果集的检索封装。
    MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。
    MyBatis是对JDBC的封装。相对于JDBC，MyBatis有以下优点：

    1. 优化获取和释放
    我们一般在访问数据库时都是通过数据库连接池来操作数据库，数据库连接池有好几种，比如C3P0、DBCP，也可能采用容器本身的JNDI数据库连接池。
    我们可以通过DataSource进行隔离解耦，我们统一从DataSource里面获取数据库连接，DataSource具体由DBCP实现还是由容器的JNDI实现都可以，
    所以我们将DataSource的具体实现通过让用户配置来应对变化。

    C3P0 xml配置：
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"       
          destroy-method="close">      
       <property name="driverClass" value=" oracle.jdbc.driver.OracleDriver "/>      

       <property name="jdbcUrl" value=" jdbc:oracle:thin:@localhost:1521:ora9i "/>      
       <property name="user" value="admin"/>      
       <property name="password" value="1234"/>      
    </bean> 

    DBCP xml配置：
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"       
           destroy-method="close">       
        <property name="driverClassName" value="com.mysql.jdbc.Driver" />      
        <property name="url" value="jdbc:mysql://localhost:3309/sampledb" />      
        <property name="username" value="root" />      
        <property name="password" value="1234" />      
    </bean>

    DURID xml配置：
    <bean name="dataSource" class="com.alibaba.druid.pool.DruidDataSource">  
    　　<property name="driverClassName">  
    　　　　<value>com.mysql.jdbc.Driver</value>  
    　　</property>  
    　　<property name="url">  
    　　　　<value>${jdbc_url_gx}</value>  
    　　</property>  
    　　<property name="username">  
    　　　　<value>${jdbc_username_gx}</value>  
    　　</property>  
    　　<property name="password">  
    　　　　<value>${jdbc_password_gx}</value>  
    　　</property>  
    </bean>

    2.SQL统一管理，对数据库进行存取操作
    我们使用JDBC对数据库进行操作时，SQL查询语句分布在各个Java类中，这样可读性差，不利于维护，当我们修改Java类中的SQL语句时要重新进行编译。
    Mybatis可以把SQL语句放在配置文件中统一进行管理，以后修改配置文件，也不需要重新就行编译部署。

    3.生成动态SQL语句
    我们在查询中可能需要根据一些属性进行组合查询，比如我们进行商品查询，我们可以根据商品名称进行查询，也可以根据发货地进行查询，
    或者两者组合查询。如果使用JDBC进行查询，这样就需要写多条SQL语句。

    Mybatis可以在配置文件中通过使用<if test=””></if>标签进行SQL语句的拼接，生成动态SQL语句。比如下面这个例子：

    <select id="getCountByInfo" parameterType="User" resultType="int">
            select count(*) from user
            <where>
                <if test="nickname!=null">
                    and nickname = #{nickname} 
                </if>
                <if test="email!=null">
                    and email = #{email} 
                </if>
            </where>
    </select>

    就是通过昵称或email或者二者的组合查找用户数。

    4.能够对结果集进行映射
    我们在使用JDBC进行查询时，返回一个结果集ResultSet,我们要从结果集中取出结果封装为需要的类型
    在Mybatis中我们可以设置将结果直接映射为自己需要的类型，比如：JavaBean对象、一个Map、一个List等等。像上个例子中就是将结果映射为int类型。
     */

    // @Autowired注解：当需要引用一个spring容器中已注入的类实例时，直接在前面加入@Autowired注解，
    // spring就会自动对已注入的所有类对象进行类型匹配，一旦匹配成功，就直接将其返回
    @Autowired
    private MasterDataSourceConfiguration masterDataSourceConfiguration;

    @Bean(name = "masterDataSource")
    public DataSource dataSource () {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(masterDataSourceConfiguration.getUrl()); //数据源
        config.setUsername(masterDataSourceConfiguration.getUsername()); //用户名
        config.setPassword(masterDataSourceConfiguration.getPassword()); //密码
        config.setDriverClassName(masterDataSourceConfiguration.getDriverClassName()); // DataSourceJDBC驱动程序提供的类的名称
        config.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
        config.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
        config.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("useLocalTransactionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");
        config.addDataSourceProperty("useUnicode", "true");
        config.addDataSourceProperty("characterEncoding", "utf8");
        config.addDataSourceProperty("readOnly", "true");

        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource;
    }
}
