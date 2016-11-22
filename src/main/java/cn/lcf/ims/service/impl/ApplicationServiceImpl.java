package cn.lcf.ims.service.impl;

import org.springframework.stereotype.Service;

import cn.lcf.ims.entity.Application;
import cn.lcf.ims.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Override
	public Application getApplication(Integer id) {
		Application application = new Application();
		application.setId(id);
		return application;
	}

}
