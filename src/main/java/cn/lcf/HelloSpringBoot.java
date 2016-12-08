package cn.lcf;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ServletComponentScan
@Configuration("classpath*:druid.xml")
public class HelloSpringBoot {
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloSpringBoot.class, args);
	}
}
