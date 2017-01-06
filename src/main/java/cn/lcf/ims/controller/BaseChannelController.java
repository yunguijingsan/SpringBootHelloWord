package cn.lcf.ims.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lcf.core.config.annotation.SwaggerTag;
import cn.lcf.core.config.annotation.SwaggerUser;
import cn.lcf.core.entity.Page;
import cn.lcf.core.exception.ResponseResult;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.entity.BaseChannel;
import cn.lcf.ims.mapper.BaseChannelMapper;

@Controller
@RequestMapping("/resources/ims/baseChannel")
@Api(tags={SwaggerTag.CHANNEL})
@SwaggerUser
public class BaseChannelController {

	
	@Autowired
	BaseChannelMapper baseChannelMapper;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "应用-添加", notes = "应用-添加", response = Application.class)
	public ResponseResult<Application> addApplication(
			@RequestBody Application application) {
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(value = "addBatch", method = RequestMethod.POST)
	@ApiOperation(value = "应用-添加", notes = "应用-添加", response = Application.class, responseContainer = "List")
	public ResponseResult<List<Application>> addApplicationBatch(
			@RequestBody Application[] application) {
		List<Application> list = new ArrayList<Application>();
		return ResponseResult.createSuccess(list);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "应用-详情", response = Application.class)
	public ResponseResult<BaseChannel> findApplicationById(Integer id) {
		return ResponseResult.createSuccess(baseChannelMapper.selectByPrimaryKey(id));
	}

	@ResponseBody
	@RequestMapping(value = "findByCodeAndName", method = RequestMethod.GET)
	@ApiOperation(value = "应用-详情", response = Application.class)
	@ApiImplicitParam(value = "应用代码")
	public ResponseResult<Application> findByCodeAndName(String code) {
		return ResponseResult.createSuccess();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "应用-修改")
	public ResponseResult<Application> updateApplication(
			@RequestBody Application application) {
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ApiOperation(value = "应用-查询")
	public ResponseResult<Page<Application>> searchApplication(
			ApplicationCondition condition) {
		return ResponseResult.createSuccess();
	}

	@ResponseBody
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@ApiOperation(value = "应用-page")
	public ResponseResult<Page<Application>> page(Page<Application> condition) {
		return ResponseResult.createSuccess();
	}

	@ResponseBody
	@RequestMapping(value = "searchApplication", method = RequestMethod.GET)
	@ApiOperation(value = "应用-搜索", response = Application.class, notes = "分页")
	public ResponseResult<Page<Application>> searchApplicationExt(
			ApplicationCondition condition) {
		return ResponseResult.createSuccess();
	}

	@ResponseBody
	@RequestMapping(value = "listApplication", method = RequestMethod.GET)
	@ApiOperation(value = "应用-搜索")
	public ResponseResult<Page<Application>> listApplication(
			ApplicationCondition condition) {
		return ResponseResult.createSuccess();
	}
}