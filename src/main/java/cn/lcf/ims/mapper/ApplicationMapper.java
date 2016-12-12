package cn.lcf.ims.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;


@Mapper
public interface ApplicationMapper {

	@Select("select * from application") 
    public List<Application> listApplication(ApplicationCondition condition);  
}
