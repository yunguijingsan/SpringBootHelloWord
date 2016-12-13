package cn.lcf.ims.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;


public interface ApplicationDao extends PagingAndSortingRepository<Application, Long>,JpaSpecificationExecutor<Application>{
	 public Application findByCode(String code);
	 
	 public Application findByCodeAndName(String code,String name);
	 
	 @Query(value="select * from application where code=:condition.code",
			 countQuery="select count(*) from application where code=:condition.code",
			 nativeQuery=true)
	 public Page<Application> searchApplication(@Param("condition")ApplicationCondition condition,Pageable pageable);
}