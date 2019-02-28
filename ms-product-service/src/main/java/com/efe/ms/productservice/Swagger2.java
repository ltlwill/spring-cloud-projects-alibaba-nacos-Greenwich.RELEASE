package com.efe.ms.productservice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * swagger2启用配置
 * </p>
 * 
 * @author liutianlong 2018年6月8日 上午11:43:46
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Value("${spring.application.name}")
	private String applicationName; // 应用名称（即注册到eureka的服务名称）

	@Bean
	public Docket createRestApi(ServletContext servletContext) {
		return new Docket(DocumentationType.SWAGGER_2)
		  	    /*
		  	     * 注:在使用spring cloud gateway作为服务网关聚合swagger2文档时，文档中的Base URL缺少服务名(服务提供者)的问题,如：localhost:8730/getProductlines,
		  	     * 应该是：localhost:8730/product-service/getProductlines才对(其中localhost:8730为网关地址)，这样就会导致在swagger页面做Try it out时请求为404,
		  	     * 为了解决使用spring cloud gateway作为网关带来的文档聚合问题，需要重写一下pathProvider，如果使用的是zuul,可以不用重写。如下所示：
		  	     */
				.pathProvider(new RelativePathProvider(servletContext) { 
					@Override
					public String getApplicationBasePath() {
						return super.getDocumentationPath() + applicationName;
					}
				})
				/**
				 * WTF: 在Spring cloud Finchely对应的Spring cloud gateway中，不需要设置此host，网关聚合swagger2文档时，host自动设置是当前网关服务的host，但是在Spring Cloud Greenwich对应的
				 * Spring cloud gateway中，会将此host的值设置为 具体服务的host（如：product-service），导致在swagger2页面对接口做 try it out时，请求直接发送到了具体服务上，没有请求到网关，
				 * 如：应该是：http://192.168.2.55:8730/product-service/products/10090683 ，但实际请求的是：http://192.168.2.55:8750/product-service/products/10090683，
				 * ，其中8730 是Gateway网关地址，8750是具体注册到eureka中的服务，最终结果是try it out 请求失败。注：zuul、Spring Cloud Gateway(Finchely)不需要
				 */
//				.host("192.168.2.55:8730")
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.efe.ms.productservice.controller"))
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.apis(RequestHandlerSelectors
						.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any()).build();
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param
	 * @author liutianlong
	 * @date 2018年6月8日 上午11:46:05
	 * @return ApiInfo
	 */
	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("基础产品服务").description("基础产品服务文档")
		// .termsOfServiceUrl("http://www.hengzhiyi.cn")
				.contact("liutl@iefiel.com").version("1.0").build();
	}
}
