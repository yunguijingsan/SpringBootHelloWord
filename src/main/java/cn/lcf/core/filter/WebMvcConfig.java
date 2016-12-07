package cn.lcf.core.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.lcf.core.interceptor.SignatureInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private SignatureInterceptor signatureInterceptor;// 需要在该拦截器上添加@Configuration注解才能注入

	@Override
  public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(signatureInterceptor).addPathPatterns("/application/*").excludePathPatterns(".html");
    }
}