package cn.lcf.core.config;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import cn.lcf.core.config.annotation.SwaggerAdmin;
import cn.lcf.core.config.annotation.SwaggerTag;
import cn.lcf.core.config.annotation.SwaggerUser;

@Configuration
@EnableSwagger2
public class Swagger2 {
	Tag app = new Tag(SwaggerTag.APP,"应用");
	Set<Tag> tags = new HashSet<Tag>();
	
	public Swagger2(){
		tags.add(new Tag(SwaggerTag.USER,"用户"));
		tags.add(new Tag(SwaggerTag.CHANNEL,"渠道"));
	}
	
	@Bean
	public Docket createRestApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build()
				.pathMapping("/").apiInfo(apiInfo()).tags(app,tags.toArray(new Tag[]{}));
		return docket;
	}

	@Bean
	public Docket adminApi() {
		return this.createApi("ADMIN", SwaggerAdmin.class);
	}
	@Bean
	public Docket creatUserApi() {
		return this.createApi("用户", SwaggerUser.class);
	}
	
	private Docket createApi(String groupName,Class<? extends Annotation> annotation){
		return new Docket(DocumentationType.SWAGGER_2).groupName(groupName)
				.select().apis(RequestHandlerSelectors.withClassAnnotation(annotation)).build()
				.apiInfo(apiInfo())
				.tags(app,tags.toArray(new Tag[]{}));
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("IMS").version("1.0").build();
	}

}