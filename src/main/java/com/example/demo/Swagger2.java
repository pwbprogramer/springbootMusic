package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
public class Swagger2 {

	@Bean
	public Docket createRestApi1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("测试文档1")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.configuration"))
				.paths(PathSelectors.any())
				.build();
	}
	
	@Bean
	public Docket createRestApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("测试文档2")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				  .title("Spring Boot中使用Swagger2构建RESTful APIs")
				  .description("Swagger2练习")
				  .termsOfServiceUrl("http://blog.didispace.com/")
				  .contact("程序猿PWB")
				  .version("1.0")
				  .build();
	}

}
