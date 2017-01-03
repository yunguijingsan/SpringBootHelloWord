package cn.lcf.ims.dao.ims;

import cn.lcf.core.entity.Page;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.dao.BaseDao;
import cn.lcf.ims.entity.Application;

public interface ApplicationDao extends BaseDao{
	public void addApplication(Application application);

	public Application findApplicationById(Integer id);

	public void updateApplication(Application application);

	public Page<Application> searchApplication(ApplicationCondition condition);

	public Application findApplicationByCode(String code);

}