package cn.lcf.ims.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lcf.core.Page;
import cn.lcf.core.exception.ResponseResult;
import cn.lcf.core.spring.FunctionInfo;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.service.ApplicationService;

@Controller
@RequestMapping("/resources/ims/application")
public class ApplicationController{

    @Autowired
    private ApplicationService applicationService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="应用-添加",functionDescription="应用-添加")
    public ResponseResult<Application> addApplication(@RequestBody Application application){
    	applicationService.addApplication(application);
	 	return ResponseResult.createSuccess(application);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="应用-详情")
    public  ResponseResult<Application> findApplicationById(Long id){
    	Application application = applicationService.findApplicationById(id);
    	return ResponseResult.createSuccess(application);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="应用-修改")
    public  ResponseResult<Application> updateApplication(@RequestBody Application application){
    	applicationService.updateApplication(application);
    	return ResponseResult.createSuccess(application);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="应用-查询")
    public  ResponseResult<Page<Application>> searchApplication(ApplicationCondition condition){
        Page<Application> application = applicationService.searchApplication(condition);
        return ResponseResult.createSuccess(application);
    }
    @ResponseBody
    @RequestMapping(value="sessionId",method=RequestMethod.GET)
    @FunctionInfo(functionName="sessionId-查询")
    public  ResponseResult<String> token(HttpServletRequest request){
        return ResponseResult.createSuccess(request.getSession().getId());
    }
}