package com.efe.ms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 
 * <p>微服务网关(spring cloud gateway实现): </p> 
 * @author Liu TianLong
 * 2018年9月19日 下午5:03:11
 */

@SpringCloudApplication
public class GatewayApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayApplication.class, args);
    }
    
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
    	// spring cloud gateway 代码式的路由实现，还可以用yml等配置方式实现
    	return builder.routes().route(r -> r.path("/efe").uri("http://www.hengzhiyi.cn")).build();
    }
}
