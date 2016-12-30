package cn.lcf.ims.service;

import cn.lcf.core.entity.Page;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;

public interface ApplicationService {

    public void addApplication(Application application);

    public Application findApplicationById(Long id);

    public void updateApplication(Application application);

    public Page<Application> searchApplication( ApplicationCondition applicationCondition );

	public Page<Application> searchApplicationExt(ApplicationCondition applicationCondition);

	public Application findByCodeAndName(String code);
}