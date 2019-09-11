package spring.boot.demo.base.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(DataSourceConfiguration.class)
@org.springframework.context.annotation.Configuration
public class MybatisConfiguration {

    /*
    MyBatis的持久化解决方案是将用户从原始的JDBC访问中解放出来,用户只需要定义需要操作的SQL语句,无须关注底层的JDBC操作,
    就可以以面向对象的方式来进行持久化层操作.底层数据库连接的获取,数据访问的实现,事务控制等都无须用户关心,
    从而将应用层从底层的JDBC/JTA API抽取出来.通过配置文件管理JDBC连接,让MyBatis解决持久化的实现.
    在MyBatis中的常见对象有SqlSessionFactory和SqlSession

    一、 SqlSessionFactory
    SqlSessionFactory是MyBatis的关键对象,它是个单个数据库映射关系经过编译后的内存镜像.
    SqlSessionFactory对象的实例可以通过SqlSessionFactoryBuilder对象类获得,
    而SqlSessionFactoryBuilder则可以从XML配置文件或一个预先定制的Configuration的实例构建出SqlSessionFactory的实例.
    每一个MyBatis的应用程序都以一个SqlSessionFactory对象的实例为核心.同时SqlSessionFactory也是线程安全的,
    SqlSessionFactory一旦被创建,应该在应用执行期间都存在.在应用运行期间不要重复创建多次,
    建议使用单例模式.SqlSessionFactory是创建SqlSession的工厂.

    二、SqlSession
    SqlSession是MyBatis的关键对象,是执行持久化操作的独享,类似于JDBC中的Connection.它是应用程序与持久层之间执行交互操作的一个单线程对象,
    也是MyBatis执行持久化操作的关键对象.SqlSession对象完全包含以数据库为背景的所有执行SQL操作的方法,它的底层封装了JDBC连接,
    可以用SqlSession实例来直接执行被映射的SQL语句.每个线程都应该有它自己的SqlSession实例.SqlSession的实例不能被共享,
    同时SqlSession也是线程不安全的,绝对不能将SqlSeesion实例的引用放在一个类的静态字段甚至是实例字段中.
    也绝不能将SqlSession实例的引用放在任何类型的管理范围中,比如Servlet当中的HttpSession对象中.
    使用完SqlSeesion之后关闭Session很重要,应该确保使用finally块来关闭它.

    三、SqlSessionFactory和SqlSession实现过程
    mybatis框架主要是围绕着SqlSessionFactory进行的，创建过程大概如下：
    (1)、定义一个Configuration对象，其中包含数据源、事务、mapper文件资源以及影响数据库行为属性设置settings
    (2)、通过配置对象，则可以创建一个SqlSessionFactoryBuilder对象
    (3)、通过 SqlSessionFactoryBuilder 获得SqlSessionFactory 的实例。
    (4)、SqlSessionFactory 的实例可以获得操作数据的SqlSession实例，通过这个实例对数据库进行操作

    四、SqlSessionFactory和SqlSession使用过程涉及到的方法为下面步骤:
    第一步首先SqlSessionFactoryBuilder去读取mybatis的配置文件，然后build一个DefaultSqlSessionFactory,即得到SqlSessionFactory
    第二步，获取到SqlSessionFactory之后，就可以利用SqlSessionFactory方法的openSession来获取SqlSession对象了。
    得到SqlSession对象之后就可以利用SqlSession内部的方法进行CRUD操作了。
    注意一点，Connection对象是在SqlSession对象创建之后进行CURD操作中创建的。
    PooledDataSource和UnPooledDataSource的区别是PooledDataSource使用了连接池。
    为什么使用连接池呢？
    因为创建一个Connection对象的过程，在底层就相当于和数据库建立的通信连接，在建立通信连接的过程，消耗了非常多的时间，
    而往往我们建立连接后（即创建Connection对象后），就执行一个简单的SQL语句，然后就要抛弃掉，
    这是一个非常大的资源浪费！mybatis针对这一个问题提出的PooledDataSource使用了连接池。
     */

    @Autowired
    private DataSource dynamicDataSource;

//    public static SqlSessionFactory getSqlSessionFactoryUsingJavaAPI() {
//        SqlSessionFactory javaSqlSessionFactory = null;
//            try {
//                DataSource dataSource = DataSourceFactory.getDataSource();
//                TransactionFactory transactionFactory = new JdbcTransactionFactory();
//                Environment environment = new Environment("development", transactionFactory, dataSource);
//                org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
//                configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
//                configuration.getTypeHandlerRegistry().register(PhoneTypeHandler.class);
//                configuration.addMapper(StudentMapper.class);
//                javaSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        return javaSqlSessionFactory;
//    }

    /*
    java 配置 mybatis sqlSessionFactory
    SqlSessionFactory mybatisConfig(String driver, String url, String username,
			String password) throws SQLException {
		// 获取DataSource，DataSource接口有多个实现类，我们用的是mybatis给我们提供的PooledDataSource
		PooledDataSource pooledDataSource = new PooledDataSource(driver, url,
				username, password);
		// 若需要配置pooledDatasource，则可以用他的set方法，如
		pooledDataSource.setLoginTimeout(6000);
		DataSource dataSource = pooledDataSource;

		// 配置事务管理，这里我们使用JDBC的事务
		TransactionFactory trcFactory = new JdbcTransactionFactory();
		// 配置Environment对象，"development"是我们给起的名字
		Environment env = new Environment("development", trcFactory, dataSource);
		// 创建Configuration对象
		Configuration config = new Configuration(env);
		//<settings></settings>中的内容在此处配置
		config.setLazyLoadingEnabled(true);

		// 起别名
		TypeAliasRegistry aliases = config.getTypeAliasRegistry();
		aliases.registerAlias("bean", TestBean.class);

		// 映射接口，若有xml文件，则xml的文件应和接口文件同名
		config.addMapper(DaoMapper.class);

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(config);
		return sqlSessionFactory;
	}

	解析：
	解析一：配置 DataSource

    PooledDataSource pooledDataSource = new PooledDataSource(driver, url,username, password);

    对应

    <dataSource type="POOLED">
          <property name="driver" value="${driver}" />
          <property name="url" value="${url}" />
          <property name="username" value="${username}" />
          <property name="password" value="${password}" />
    </dataSource>


    解析二：配置 JDBC 事务
    TransactionFactory trcFactory = new JdbcTransactionFactory();

    对应

    <transactionManager type="JDBC" />


    解析三：配置Environment
    Environment env = new Environment("development", trcFactory, dataSource);

    对应

    <environment id="development">
        <transactionManager type="JDBC" />
        <dataSource type="POOLED"></dataSource>
    </environment>


    解析四：装入Configuration
    Configuration config = new Configuration(env);
    对应
    <configuration>
        <environments default="development">
            <environment id="development">
            </environment>
        </environments>
    </configuration>

    -------
    config.setLazyLoadingEnabled(true);
    对应
    <settings>
      <setting name="lazyLoadingEnabled" value="true"/>
    <settings>


    解析五：配置别名
    TypeAliasRegistry aliases = config.getTypeAliasRegistry();
    aliases.registerAlias("bean", TestBean.class);

    对应

    <typeAliases>
      <typeAlias alias="bean" type="com.amiu.TestBean"/>
    </typeAliases>


    解析六：添加映射XML，xml名称应和DaoMapper.class并且在同一个包下
    config.addMapper(DaoMapper.class);

    对应

    <mappers>
        <mapper resource="com/amiu/mybatis/DaoMapper.xml"/>
    </mappers>


    对应的mybatisConfig.xml

    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">

    <configuration>
        <!-- 导入配置文件 -->
        <properties resource="com/amiu/mybatis/dbConfig.properties" />
        <environments default="development">
            <environment id="development">
                <!-- 使用jdbc事务管理,事务控制由mybatis管理-->
                <transactionManager type="JDBC" />
                <!-- 数据库连接池,由mybatis管理-->
                <dataSource type="POOLED">
                    <property name="driver" value="${driver}" />
                    <property name="url" value="${url}" />
                    <property name="username" value="${username}" />
                    <property name="password" value="${password}" />
                </dataSource>
            </environment>
        </environments>
        <!-- 延迟加载的全局开关 -->
        <settings>
            <setting name="lazyLoadingEnabled" value="true"/>
        <settings>
        <!-- 配置别名 -->
        <typeAliases>
            <typeAlias alias="bean" type="com.amiu.TestBean"/>
        </typeAliases>
        <!-- 配置mapper -->
        <mappers>
            <mapper resource="com/amiu/mybatis/DaoMapper.xml"/>
        </mappers>
    </configuration>
     */


    @Bean
    public SqlSessionFactory mybatisConfig() throws SQLException {
//        // 获取DataSource，DataSource接口有多个实现类，我们用的是mybatis给我们提供的PooledDataSource
//        PooledDataSource pooledDataSource = new PooledDataSource(driver, url,
//                                                                 username, password);
//        // 若需要配置pooledDatasource，则可以用他的set方法，如
//        pooledDataSource.setLoginTimeout(6000);
//        DataSource dataSource = pooledDataSource;

        // 配置事务管理，这里我们使用JDBC的事务
        TransactionFactory trcFactory = new JdbcTransactionFactory();
        // 配置Environment对象，"development"是我们给起的名字
        Environment env = new Environment("development", trcFactory, dynamicDataSource);
        // 创建Configuration对象
        Configuration config = new Configuration(env);
        //<settings></settings>中的内容在此处配置
        config.setLazyLoadingEnabled(true);

//        // 起别名
//        TypeAliasRegistry aliases = config.getTypeAliasRegistry();
//        aliases.registerAlias("bean", TestBean.class);

        // 映射接口，若有xml文件，则xml的文件应和接口文件同名
//        config.addMapper(AcctMapper.class);
        config.addMappers("spring.boot.demo.dao.mapper.demo");

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(config);
        return sqlSessionFactory;
    }

}
