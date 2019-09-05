package spring.boot.demo.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

public class Mybatis3_ReplacePrefixPlugin extends PluginAdapter {

    protected final static String PREFIX = "ACC";

    @Override
    public boolean validate (List<String> warnings) {
        return true;
    }

    @Override
    public void initialized (IntrospectedTable introspectedTable) {
        // 替换 PREFIX 前缀
        String XmlMapperFileName = introspectedTable.getMyBatis3XmlMapperFileName();
        introspectedTable.setMyBatis3XmlMapperFileName(XmlMapperFileName.replace(PREFIX, ""));

        String JavaMapperType = introspectedTable.getMyBatis3JavaMapperType();
        introspectedTable.setMyBatis3JavaMapperType(JavaMapperType.replace(PREFIX, ""));

        String ExampleType = introspectedTable.getExampleType();
        introspectedTable.setExampleType(ExampleType.replace(PREFIX, ""));

        String PrimaryKeyType = introspectedTable.getPrimaryKeyType();
        introspectedTable.setPrimaryKeyType(PrimaryKeyType.replace(PREFIX, ""));

        String BaseRecordType = introspectedTable.getBaseRecordType();
        introspectedTable.setBaseRecordType(BaseRecordType.replace(PREFIX, ""));
    }
}
