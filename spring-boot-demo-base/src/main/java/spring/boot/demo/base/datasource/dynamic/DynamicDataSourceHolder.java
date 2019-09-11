package spring.boot.demo.base.datasource.dynamic;

/**
 * 动态数据源持有者，负责利用ThreadLocal存取数据源名称
 */
public class DynamicDataSourceHolder {
    /**
     * 本地线程共享对象
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 设置当前数据源
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {
        THREAD_LOCAL.set(dataSource);
    }

    /**
     * 获取当前数据源
     * @return
     */
    public static String getDataSource() {
        return THREAD_LOCAL.get();
    }

    /**
     * 清除当前数据源
     */
    public static void removeDataSource() {
        THREAD_LOCAL.remove();
    }
}
