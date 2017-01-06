package cn.lcf.ims.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.lcf.ims.entity.BaseChannel;


@Mapper
public interface BaseChannelMapper {

	@Select("select * from EIH_BASE_CHANNEL where id = #{id}")
	BaseChannel selectByPrimaryKey(Integer id);
}
