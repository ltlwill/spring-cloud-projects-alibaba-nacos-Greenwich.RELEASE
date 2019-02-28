package com.efe.ms.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * netflix eureka服务注册中心
 * 
 * @author liutianlong
 * @date 2018年5月29日 下午5:21:27
 *
 */
@EnableEurekaServer
//@SpringBootApplication
@SpringCloudApplication
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
