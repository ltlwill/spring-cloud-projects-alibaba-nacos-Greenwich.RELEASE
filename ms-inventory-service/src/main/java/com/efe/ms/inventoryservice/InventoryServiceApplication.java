package com.efe.ms.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

/**
 * 库存服务
 * @author EFE050
 *
 */
@SpringCloudApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableDistributedTransaction // 开启tx-lcn分布式事务控制
public class InventoryServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryServiceApplication.class, args); 
    }
}
