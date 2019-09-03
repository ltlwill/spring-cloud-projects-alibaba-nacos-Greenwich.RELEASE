package com.efe.ms.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * <p>服务网关(使用netflix的zuul框架实现): </p> 
 * @author Liu TianLong
 * 2018年9月21日 上午10:59:38
 */
@EnableZuulProxy
@SpringCloudApplication
@ComponentScan(basePackages="com.efe.ms") // 需要包含ms-common项目下的，否则扫描不到ms-common项目下的bean信息
public class ZuulGatewayApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulGatewayApplication.class, args); 
    }
}
