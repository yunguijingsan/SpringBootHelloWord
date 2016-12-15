package cn.lcf.core.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:application-druid.xml",
		"classpath:mybatis-config.xml" })
public class ConfigClass {
}
