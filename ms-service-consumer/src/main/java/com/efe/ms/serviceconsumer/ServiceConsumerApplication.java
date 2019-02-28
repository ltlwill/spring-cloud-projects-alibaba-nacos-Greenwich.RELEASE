package com.efe.ms.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * <p>
 * 服务消费应用:
 * </p>
 * 
 * @author Liu TianLong 2019年2月19日 上午10:39:23
 */
@EnableFeignClients
@SpringCloudApplication
public class ServiceConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
