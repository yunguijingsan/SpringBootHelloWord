package cn.lcf.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;

@Mapper
public interface ApplicationDao {
	public List<Application> searchApplication(ApplicationCondition condition);
}
