package com.efe.ms.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 库存服务
 * @author EFE050
 *
 */
@SpringCloudApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient
//@EnableCircuitBreaker
public class InventoryServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryServiceApplication.class, args); 
    }
}
