package cn.lcf.ims.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.lcf.ims.entity.Url;

@Mapper
public interface UrlMapper {
	
	@Select(value="select * from url where (isnull(#{applicationId}) or applicationId = #{applicationId})")
	public List<Url> searchUrlByApplicationId(@Param("applicationId")Integer applicationId);
}
