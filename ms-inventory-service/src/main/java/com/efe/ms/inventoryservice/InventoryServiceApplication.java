package com.efe.ms.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 库存服务
 * @author EFE050
 *
 */
//@SpringCloudApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableCircuitBreaker
public class InventoryServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryServiceApplication.class, args); 
    }
}
