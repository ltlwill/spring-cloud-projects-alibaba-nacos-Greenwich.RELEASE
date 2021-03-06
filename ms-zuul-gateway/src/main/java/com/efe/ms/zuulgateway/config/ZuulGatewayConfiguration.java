package com.efe.ms.zuulgateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.efe.ms.zuulgateway.interceptor.ZuulGatewayInterceptor;

/**
 * 1.只能有一个类继承WebMvcConfigurationSupport或实现WebMvcConfigurer，多个得话只会有一个生效。
 * 2.zuul直接转发到其他服务时(如：localhost:8731/product-service/product/1111)，不会执行此拦截器
 * 
 * @author TianLong Liu
 * @date 2019年8月30日 上午10:17:31
 */
@Configuration
// public class ZuulGatewayConfiguration implements WebMvcConfigurer {
public class ZuulGatewayConfiguration extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ZuulGatewayInterceptor()).addPathPatterns(
				"/**");

	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 解决继承WebMvcConfigurationSupport或实现WebMvcConfigurer后 swagger资源访问404的问题
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/META-INF/resources/")
				.setCachePeriod(0);
	}
}
