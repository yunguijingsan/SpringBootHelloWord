package cn.lcf.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:application-druid.xml"})
public class ConfigClass {
}
