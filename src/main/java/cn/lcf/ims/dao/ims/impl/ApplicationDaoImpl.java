package cn.lcf.ims.dao.ims.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import cn.lcf.core.entity.Page;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.dao.impl.BaseDaoImpl;
import cn.lcf.ims.dao.ims.ApplicationDao;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.mapper.ApplicationMapper;

@Repository
@Order(value=Ordered.HIGHEST_PRECEDENCE)
public class ApplicationDaoImpl extends BaseDaoImpl implements ApplicationDao {

	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Override
	public void addApplication(Application application) {
		applicationMapper.insert(application);
	}

	@Override
	public Application findApplicationById(Integer id) {
		return applicationMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateApplication(Application application) {
		this.applicationMapper.updateByPrimaryKey(application);
	}

	@Override
	public Page<Application> searchApplication(ApplicationCondition condition) {
		List<Application> list =  this.applicationMapper.searchApplication(condition);
		return new Page();
	}

	@Override
	public Application findApplicationByCode(String code) {
		return this.applicationMapper.findApplicationByCode(code);
	}

}
