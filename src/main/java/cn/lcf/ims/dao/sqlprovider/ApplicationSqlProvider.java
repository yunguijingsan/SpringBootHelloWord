package cn.lcf.ims.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

import cn.lcf.ims.entity.Application;

public class ApplicationSqlProvider {

	private static final String TABLE_NAME = "application";

	public String addApplication(Application application) {
		String sql = new SQL().INSERT_INTO(TABLE_NAME)
				.VALUES("name", "#{name}").VALUES("code", "#{code}")
				.VALUES("description", "#{description}")
				.VALUES("base_path", "#{basePath}").toString();

		System.out.println(sql);
		return sql;
	}

	public String updateApplication(Application application) {
		String sql = new SQL().UPDATE(TABLE_NAME)
				.SET("name=#{name}")
				.SET("code=#{code}")
				.SET("description=#{description}")
				.SET("base_path=#{basePath}")
				.WHERE("id=#{id}").toString();

		System.out.println(sql);
		return sql;

	}
}
