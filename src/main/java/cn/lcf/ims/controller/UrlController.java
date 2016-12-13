package cn.lcf.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lcf.core.exception.ResponseResult;
import cn.lcf.core.spring.FunctionInfo;
import cn.lcf.ims.entity.Url;
import cn.lcf.ims.mapper.UrlMapper;

@Controller
@RequestMapping("/resources/ims/url")
public class UrlController{

	
	@Autowired
	private UrlMapper urlMapper;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="URL-添加")
    public ResponseResult addUrl(@RequestBody Url url){
	 	return ResponseResult.createSuccess(url);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="URL-详情")
    public ResponseResult findUrlById(Integer id){
    	return ResponseResult.createSuccess();
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="URL-修改")
    public ResponseResult updateUrl(@RequestBody Url url){
    	return ResponseResult.createSuccess(url);
    }

    @ResponseBody
    @RequestMapping(value="search/byApplicationId",method=RequestMethod.GET)
    @FunctionInfo(functionName="URL-查询")
    public ResponseResult<List<Url>> searchUrlByApplicationId(Integer applicationId){
        return ResponseResult.createSuccess(urlMapper.searchUrlByApplicationId(applicationId));
    }
}