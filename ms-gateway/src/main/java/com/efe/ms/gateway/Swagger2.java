/*package com.efe.ms.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*//**
 * <p>
 * swagger2启用配置（spring cloud gateway项目中需要配置）
 * </p>
 * 
 * @author liutianlong 2018年6月8日 上午11:43:46
 *//*
@Configuration
//@EnableSwagger2 // 需要servlet容器，否则应用启动不了，但是spring cloud gateway又依赖rector实现
// 集成swagger2
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo());
	}

	*//**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param
	 * @author liutianlong
	 * @date 2018年6月8日 上午11:46:05
	 * @return ApiInfo
	 *//*
	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("微服务接口文档").description("微服务文接口档聚合(Spring Cloud Gateway)")
				.termsOfServiceUrl("http://www.hengzhiyi.cn")
				.contact("liutl@iefiel.com").version("1.0").build();
	}
}
*/