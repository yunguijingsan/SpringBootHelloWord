package cn.lcf.ims.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.lcf.ims.entity.Application;


public interface ApplicationDao extends PagingAndSortingRepository<Application, Long>,JpaSpecificationExecutor<Application>{
	 public Application findByCode(String code);
}