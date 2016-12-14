package cn.lcf.common;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.lcf.core.entity.Page;
import cn.lcf.core.exception.ResponseResult;
import cn.lcf.core.spring.CustomFastJsonHttpMessageConverter;
import cn.lcf.ims.condition.ApplicationCondition;
import cn.lcf.ims.entity.Application;

import com.alibaba.fastjson.serializer.SerializerFeature;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TestComplexPropertyFilter {
	
	ApplicationCondition condition = new ApplicationCondition();
	ResponseResult responseResult = ResponseResult.createSuccess(condition);
	
	{
		List<Application> list = new ArrayList<>();
		list.add(new Application());
		condition.setData(list);
	}
	@Test
	public void testAll() {
		String json = CustomFastJsonHttpMessageConverter.serializeToJson(
				responseResult, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}
	
	@Test
	public void testIncludeAll() {
		responseResult.include(Page.class, "code","data");
		String json = CustomFastJsonHttpMessageConverter.serializeToJson(
				responseResult, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}
	@Test
	public void testInclude() {
		responseResult.include(Page.class, "code","data").include(Application.class, "name","code");
		String json = CustomFastJsonHttpMessageConverter.serializeToJson(
				responseResult, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

	@Test
	public void testExclude() {
		responseResult.exclude(Page.class, "code","name","description","basePath").exclude(Application.class, "name","code");
		String json = CustomFastJsonHttpMessageConverter.serializeToJson(
				responseResult, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}
	
	@Test
	public void test(){
		Integer a=0x9fffffff,b=99999;
		System.out.println(a+1);

		Integer c=-99, d=-99;
		System.out.println(c==d);

	}
}
