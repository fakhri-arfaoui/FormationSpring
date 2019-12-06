package com.comm.comm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ConfigurationProperties
public class CommApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommApplication.class, args);
	}

}
