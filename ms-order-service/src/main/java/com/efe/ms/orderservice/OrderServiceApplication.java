package com.efe.ms.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 订单服务
 * @author EFE050
 *
 */
@SpringCloudApplication
@EnableFeignClients
public class OrderServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServiceApplication.class, args); 
    }
    
    @Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
