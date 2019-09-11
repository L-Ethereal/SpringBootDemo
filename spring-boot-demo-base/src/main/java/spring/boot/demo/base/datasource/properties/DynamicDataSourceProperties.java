package spring.boot.demo.base.datasource.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import spring.boot.demo.base.datasource.master.MasterDataSourceProperties;
import spring.boot.demo.base.datasource.slave.SlaveDataSourceProperties;

//@Setter
//@Getter
//// @Data注解中包含了get，set和toString
//@Data
@Component
// @ConfigurationProperties注解的作用是将指定的配置文件映射到该类。也就是：配置文件值→同名类属性
//@ConfigurationProperties(prefix = "hikari")
// 指定读取配置文件 可以指定多个配置文件 用逗号隔开 忽略不存在的配置文件
//@PropertySource( value = {"classpath:/config/datasource.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8", name = "datasource.properties")
public class DynamicDataSourceProperties {

//    /**
//     *  master 数据源配置
//     */
//    private HikariDataSource master;
//    /**
//     *  slave 数据源配置
//     */
//    private HikariDataSource slave;
//
//    public HikariDataSource getMaster() {
//        return masterDataSource();
//    }
//
//    public void setMaster(HikariDataSource master) {
//        this.master = master;
//    }
//
//    public HikariDataSource getSlave() {
//        return slaveDataSource();
//    }
//
//    public void setSlave(HikariDataSource slave) {
//        this.slave = slave;
//    }

    @Autowired
    private MasterDataSourceProperties masterDataSourceProperties;
    @Autowired
    private SlaveDataSourceProperties slaveDataSourceProperties;

    public HikariDataSource  masterDataSource () {
        HikariConfig masterConfig = new HikariConfig();
        masterConfig.setJdbcUrl(masterDataSourceProperties.getJdbcUrl()); //数据源
        masterConfig.setUsername(masterDataSourceProperties.getUsername()); //用户名
        masterConfig.setPassword(masterDataSourceProperties.getPassword()); //密码
        masterConfig.setDriverClassName(masterDataSourceProperties.getDriverClassName()); // DataSourceJDBC驱动程序提供的类的名称
        masterConfig.setPoolName(masterDataSourceProperties.getPoolName());
        masterConfig.setReadOnly(masterDataSourceProperties.isReadOnly()); // 设置是否只可读
        masterConfig.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
        masterConfig.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
        masterConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
        masterConfig.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
        masterConfig.addDataSourceProperty("useLocalSessionState", "true");
        masterConfig.addDataSourceProperty("useLocalTransactionState", "true");
        masterConfig.addDataSourceProperty("rewriteBatchedStatements", "true");
        masterConfig.addDataSourceProperty("cacheResultSetMetadata", "true");
        masterConfig.addDataSourceProperty("cacheServerConfiguration", "true");
        masterConfig.addDataSourceProperty("elideSetAutoCommits", "true");
        masterConfig.addDataSourceProperty("maintainTimeStats", "false");
        masterConfig.addDataSourceProperty("useUnicode", "true");
        masterConfig.addDataSourceProperty("characterEncoding", "utf8");

        HikariDataSource hikariMasterDataSource = new HikariDataSource(masterConfig);
        return hikariMasterDataSource;
    }

    public HikariDataSource slaveDataSource() {
        HikariConfig slaveConfig = new HikariConfig();
        slaveConfig.setJdbcUrl(slaveDataSourceProperties.getJdbcUrl()); //数据源
        slaveConfig.setUsername(slaveDataSourceProperties.getUsername()); //用户名
        slaveConfig.setPassword(slaveDataSourceProperties.getPassword()); //密码
        slaveConfig.setDriverClassName(slaveDataSourceProperties.getDriverClassName()); // DataSourceJDBC驱动程序提供的类的名称
        slaveConfig.setMinimumIdle(slaveDataSourceProperties.getHikariMinimumIdle());
        slaveConfig.setAutoCommit(slaveDataSourceProperties.isHikariAutoCommit());
        slaveConfig.setConnectionTimeout(slaveDataSourceProperties.getHikariConnectionTimeout());
        slaveConfig.setConnectionTestQuery(slaveDataSourceProperties.getHikariConnectionTestQuery());
        slaveConfig.setMaximumPoolSize(slaveDataSourceProperties.getMaximumPoolSize());
        slaveConfig.setPoolName(slaveDataSourceProperties.getPoolName());
        slaveConfig.setIdleTimeout(slaveDataSourceProperties.getIdleTimeout());
        slaveConfig.setMaxLifetime(slaveDataSourceProperties.getMaxLifetime());
        slaveConfig.setReadOnly(slaveDataSourceProperties.isReadOnly()); // 设置是否只可读


        slaveConfig.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
        slaveConfig.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
        slaveConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
        slaveConfig.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
        slaveConfig.addDataSourceProperty("useLocalSessionState", "true");
        slaveConfig.addDataSourceProperty("useLocalTransactionState", "true");
        slaveConfig.addDataSourceProperty("rewriteBatchedStatements", "true");
        slaveConfig.addDataSourceProperty("cacheResultSetMetadata", "true");
        slaveConfig.addDataSourceProperty("cacheServerConfiguration", "true");
        slaveConfig.addDataSourceProperty("elideSetAutoCommits", "true");
        slaveConfig.addDataSourceProperty("maintainTimeStats", "false");
        slaveConfig.addDataSourceProperty("useUnicode", "true");
        slaveConfig.addDataSourceProperty("characterEncoding", "utf8");

        HikariDataSource hikariSlaveDataSource = new HikariDataSource(slaveConfig);
        return hikariSlaveDataSource;
    }

}
