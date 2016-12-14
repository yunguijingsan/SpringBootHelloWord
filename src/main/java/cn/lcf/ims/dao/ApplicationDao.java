package cn.lcf.ims.dao;

import java.awt.print.Pageable;

import org.apache.ibatis.annotations.Param;

import cn.lcf.core.entity.Page;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;


public interface ApplicationDao {
	 public Application findByCodeAndName(String code,String name);
	 
	 public Page<Application> searchApplication(@Param("condition")ApplicationCondition condition,Pageable pageable);
}