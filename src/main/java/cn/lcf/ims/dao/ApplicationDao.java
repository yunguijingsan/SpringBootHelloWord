package cn.lcf.ims.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;


public interface ApplicationDao extends PagingAndSortingRepository<Application, Long>,JpaSpecificationExecutor<Application>{
	 public Application findByCode(String code);
	 
	 public Application findByCodeAndName(String code,String name);
	 
	 @Query(value="select * from application",countQuery="select count(*) from application",
			 nativeQuery=true)
	 public List<Application> searchApplication(ApplicationCondition condition);
}