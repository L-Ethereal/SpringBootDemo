package spring.boot.demo.mybatis.generator.tools;

import java.math.BigDecimal;
import java.sql.Types;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 *
 *
 * 数据库的类型和 Model 中 Java 类型的关系是由 JavaTypeResolver 控制的,
 * 可以在生成配置中指定表中的某一个字段的 JavaType, 但不能全局配置.
 * 如果想改某一个表的话某个字段, 只需要在 table 标签下指定 <columnOverride column="" javaType=""/> 即可
 */
public class JavaTypeResolverImpl extends JavaTypeResolverDefaultImpl {

    //  如果想控制映射关系, 有两个方案
    //  1.编写一个插件
    //  2.扩展 JavaTypeResolverDefaultImpl 并更改 calculateJavaType 方法, 在 TypeResolver 配置自己的实现
//    public JavaTypeResolverImpl() {
//        super();
//        //把数据库的 TINYINT 映射成 Integer
//        super.typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
//    }

    @Override
    public FullyQualifiedJavaType calculateJavaType (IntrospectedColumn introspectedColumn) {

        FullyQualifiedJavaType answer = null;
        JdbcTypeInformation jdbcTypeInformation = typeMap.get(introspectedColumn.getJdbcType());

        if (null == jdbcTypeInformation) {
           switch(introspectedColumn.getJdbcType()) {
               case Types.BIGINT:
               case Types.DECIMAL:
               case Types.NUMERIC:
                   if (introspectedColumn.getScale() > 0
                        || forceBigDecimals) {
                       answer = new FullyQualifiedJavaType(BigDecimal.class.getName());
                   } else if (introspectedColumn.getScale() > 9) {
                       answer = new FullyQualifiedJavaType(Long.class.getName());
                   } else if (introspectedColumn.getScale() > 4) {
                       answer = new FullyQualifiedJavaType(Integer.class.getName());
                   } else {
                       answer = new FullyQualifiedJavaType(Integer.class.getName());
                   }
                   break;

               default:
                   answer = null;
                   break;
           }
        } else {
            switch (introspectedColumn.getActualColumnName()) {
                case "calcschednbr"   :
                case "agreementseqno" :
                case "intbase"        :
                    answer = new FullyQualifiedJavaType(Long.class.getName());
                    break;
                default:
                    if (Types.INTEGER == introspectedColumn.getJdbcType()
                            && introspectedColumn.getActualColumnName().endsWith("yn")) {
                        // 将 INTEGER 类型 且以 yn 结尾的字段 改为 String 类型
                        answer = new FullyQualifiedJavaType(String.class.getName());
                    } else if (Types.INTEGER == introspectedColumn.getJdbcType() &&
                               (introspectedColumn.getActualColumnName().equalsIgnoreCase("isitlemployee")
                                    || introspectedColumn.getActualColumnName().equalsIgnoreCase("isnative"))) {
                        // 将 is 开头的字段 改为 String
                        answer = new FullyQualifiedJavaType(String.class.getName());
                    } else {
                        answer = jdbcTypeInformation.getFullyQualifiedJavaType();
                    }
                    break;
            }
        }

        return answer;
    }
}
