package cn.lcf.ims.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.models.Swagger;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import cn.lcf.core.config.annotation.SwaggerAdmin;
import cn.lcf.core.config.annotation.SwaggerTag;
import cn.lcf.core.entity.Page;
import cn.lcf.core.exception.ResponseResult;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.dao.ims.ApplicationDao;
import cn.lcf.ims.entity.Application;
import cn.lcf.ims.service.ApplicationService;

import com.google.common.base.Optional;

@Controller
@RequestMapping("/resources/ims/application")
@Api(tags={SwaggerTag.APP})
@SwaggerAdmin
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private DocumentationCache documentationCache;

	@Autowired(required = false)
	private ApplicationDao applicationDao;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation("应用-添加")
	@SwaggerAdmin
	public ResponseResult<Application> addApplication(
			@RequestBody Application application) {
		applicationService.addApplication(application);
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
	public ResponseResult<Application> findApplicationById(Long id) {
		Application application = applicationService.findApplicationById(id);
		System.out.print(documentationCache.documentationByGroup("default"));
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(value = "findByCodeAndName", method = RequestMethod.GET)
	@ApiOperation(value = "应用-详情", response = Application.class)
	public ResponseResult<Application> findByCodeAndName(String code) {
		Application application = this.applicationService
				.findByCodeAndName(code);
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "应用-修改")
	public ResponseResult<Application> updateApplication(
			@RequestBody Application application) {
		applicationService.updateApplication(application);
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ApiOperation(value = "应用-查询")
	@ApiParam(name="name",value="应用名称Param",hidden=true)
	public ResponseResult<Page<Application>> searchApplication(
			ApplicationCondition condition) {
		Page<Application> application = applicationService
				.searchApplication(condition);
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@ApiOperation(value = "应用-page")
	public ResponseResult<Page<Application>> page(Page<Application> condition) {
		Page<Application> application = applicationService
				.searchApplication(null);
		return ResponseResult.createSuccess(application);
	}

	@ResponseBody
	@RequestMapping(value = "searchApplication", method = RequestMethod.GET)
	@ApiOperation(value = "应用-搜索", response = Application.class, notes = "分页")
	public ResponseResult<Page<Application>> searchApplicationExt(
			ApplicationCondition condition) {

		return ResponseResult.createSuccess(this.applicationService
				.searchApplicationExt(condition));
	}

	@ResponseBody
	@RequestMapping(value = "listApplication", method = RequestMethod.GET)
	@ApiOperation(value = "应用-搜索")
	public ResponseResult<Page<Application>> listApplication(
			ApplicationCondition condition) {
		return ResponseResult.createSuccess(applicationService
				.searchApplication(condition));
	}

	@Autowired
	private ServiceModelToSwagger2Mapper mapper;

	@ResponseBody
	@RequestMapping(value = "sessionId", method = RequestMethod.GET)
	@ApiOperation(value = "sessionId-查询")
	public ResponseResult<Swagger> token(
			@RequestParam(value = "group", required = false) String swaggerGroup,
			HttpServletRequest servletRequest) {

		String groupName = Optional.fromNullable(swaggerGroup).or(
				Docket.DEFAULT_GROUP_NAME);
		Documentation documentation = documentationCache
				.documentationByGroup(groupName);
		if (documentation == null) {
			return ResponseResult.createSuccess();
		}
		Swagger swagger = mapper.mapDocumentation(documentation);

		return ResponseResult.createSuccess(swagger);
	}
}