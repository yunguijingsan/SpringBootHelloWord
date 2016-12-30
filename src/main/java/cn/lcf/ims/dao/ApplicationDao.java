package cn.lcf.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.dao.sqlprovider.ApplicationSqlProvider;
import cn.lcf.ims.entity.Application;

@Mapper
public interface ApplicationDao{

	@InsertProvider(type=ApplicationSqlProvider.class,method="addApplication")
    public void addApplication(Application application);

	@Select("select * from application where id=#{id}")
    public Application findApplicationById(Integer id);

	@UpdateProvider(type=ApplicationSqlProvider.class,method="updateApplication")
    public void updateApplication(Application application);

    @Select("select * from application")
    public List<Application> searchApplication(ApplicationCondition applicationCondition);

    @Select("select * from application where code=#{code}")
	public Application findApplicationByCode(String code);
}