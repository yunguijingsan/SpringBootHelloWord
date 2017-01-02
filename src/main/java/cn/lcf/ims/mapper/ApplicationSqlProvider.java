package cn.lcf.ims.mapper;

import cn.lcf.ims.entity.Application;
import org.apache.ibatis.jdbc.SQL;

public class ApplicationSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public String insertSelective(Application record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("application");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getBasePath() != null) {
            sql.VALUES("base_path", "#{basePath,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public String updateByPrimaryKeySelective(Application record) {
        SQL sql = new SQL();
        sql.UPDATE("application");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getBasePath() != null) {
            sql.SET("base_path = #{basePath,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}