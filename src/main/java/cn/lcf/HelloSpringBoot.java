package cn.lcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration 
@ComponentScan
@Configuration
public class HelloSpringBoot {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloSpringBoot.class, args);
	}
}
