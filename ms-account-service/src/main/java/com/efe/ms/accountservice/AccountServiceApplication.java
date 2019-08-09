package com.efe.ms.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

/**
 * 账户服务
 * @author TianLong Liu
 * @date 2019年8月8日 下午4:24:09
 */
@SpringCloudApplication
@EnableDistributedTransaction // 开启tx-lcn分布式事务控制
public class AccountServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(AccountServiceApplication.class, args); 
    }
}
