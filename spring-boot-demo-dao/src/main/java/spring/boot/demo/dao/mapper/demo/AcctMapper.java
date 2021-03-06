package spring.boot.demo.dao.mapper.demo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import spring.boot.demo.dao.generate.demo.Acct;
import spring.boot.demo.dao.generate.demo.AcctExample;
import spring.boot.demo.dao.generate.demo.AcctKey;

public interface AcctMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    long countByExample(AcctExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int deleteByExample(AcctExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int deleteByPrimaryKey(AcctKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int insert(Acct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int insertSelective(Acct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    List<Acct> selectByExample(AcctExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    Acct selectByPrimaryKey(AcctKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") Acct record, @Param("example") AcctExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int updateByExample(@Param("record") Acct record, @Param("example") AcctExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int updateByPrimaryKeySelective(Acct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct
     *
     * @mbg.generated Thu Sep 05 10:27:40 CST 2019
     */
    int updateByPrimaryKey(Acct record);
}