package cn.lcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ServletComponentScan
@Configuration("classpath*:druid.xml")
public class HelloSpringBoot {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloSpringBoot.class, args);
	}
}
