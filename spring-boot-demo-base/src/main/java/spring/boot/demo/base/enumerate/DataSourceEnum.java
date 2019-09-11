package spring.boot.demo.base.enumerate;

public enum DataSourceEnum {

    MASTER("master", "主数据源"),
    SLAVE("slave", " 附属数据源"),
    DYNAMIC("dynamic", " 动态数据源");

    private String dataSource;
    private String dataSourceDesc;

    DataSourceEnum (String dataSource, String dataSourceDesc) {
        this.dataSource = dataSource;
        this.dataSourceDesc = dataSourceDesc;
    }

    public String dataSource () {
        return dataSource;
    }

    public String dataSourceDesc () {
        return dataSourceDesc;
    }
}
