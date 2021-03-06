package cn.lcf.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lcf.core.entity.Page;
import cn.lcf.core.exception.ServiceException;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.dao.ims.ApplicationDao;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired(required=false)
	private ApplicationDao applicationDao;
 
	public void addApplication(Application application) {
		this.validate(application);
		applicationDao.addApplication(application);
	}

	public Application findApplicationById(Long id) {
		return this.applicationDao.findApplicationById(id.intValue());
	}

	public void updateApplication(Application application) {
		this.applicationDao.updateApplication(application);
	}

	public Page<Application> searchApplication(
			final ApplicationCondition condition) {
		return this.applicationDao.searchApplication(condition);
	}

	private void validate(Application application) {
		if (application == null) {
			throw ServiceException.create("APPLICATION.IS.NULL");
		}
	}

	private void validateId(Long id) {
		if (id == null) {
			throw ServiceException.create("APPLICATION.ID.IS.NULL");
		}
	}


	@Override
	public Page<Application> searchApplicationExt(ApplicationCondition condition) {
		
		return new Page();
	}

	@Override
	public Application findByCodeAndName(String code) {
		return this.applicationDao.findApplicationByCode(code);
	}

}