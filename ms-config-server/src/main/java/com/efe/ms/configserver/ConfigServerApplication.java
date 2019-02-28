package com.efe.ms.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * <p>微服务配置中心: </p> 
 * @author Liu TianLong
 * 2018年8月15日 上午11:13:19
 */
@EnableConfigServer
@SpringCloudApplication
public class ConfigServerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
