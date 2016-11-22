package cn.lcf.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcf.core.exception.ResponseResult;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class SpringTestApplication {

	@Autowired
	ApplicationService applicationService;

	@RequestMapping("/home")
	String home() {
		return "Hello World!";
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	ResponseResult<Application> get(Integer id) {
		return ResponseResult.createSuccess(this.applicationService.getApplication(id));
	}

}