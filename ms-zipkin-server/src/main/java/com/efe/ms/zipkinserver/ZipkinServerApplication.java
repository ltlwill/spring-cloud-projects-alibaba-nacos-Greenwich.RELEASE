package com.efe.ms.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import zipkin2.server.internal.EnableZipkinServer;

/**
 * 
 * <p>zipkin链路跟踪服务(注：spring cloud finchley后，官方不建议自定义zipkin-server,已经提供官方打包好的jar包，直接启动即可,默认端口:9411): </p> 
 * @author Liu TianLong
 * 2018年8月29日 下午2:49:25
 */

@EnableZipkinServer
@SpringCloudApplication
public class ZipkinServerApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
