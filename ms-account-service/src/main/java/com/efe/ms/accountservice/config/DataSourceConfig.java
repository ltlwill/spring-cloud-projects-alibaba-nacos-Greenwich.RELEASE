package com.efe.ms.accountservice.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据库配置(使用alibaba seata 实现分布式事务)
 * @author TianLong Liu
 * @date 2019年7月30日 下午4:25:36
 */
//@Configuration
//@ConditionalOnClass(HikariDataSource.class)
public class DataSourceConfig {
	
	/*@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public HikariDataSource hikariDataSource(){
//		return DataSourceBuilder.create().build();
		return new HikariDataSource();
	}*/
	
	/**
     * 需要将 DataSourceProxy 设置为主数据源，否则seata事务无法回滚(注：使用 默认的hikari数据库连接池时，总是会报一些错误,使用druid才正常)
     *
     * @param druidDataSource The DruidDataSource
     * @return The default datasource
     */
	/*@Bean("dataSource")
	@Primary
	public DataSource dataSource(HikariDataSource hikariDataSource){
		return new DataSourceProxy(hikariDataSource); 
	}*/
	
	
//	@Bean
//	@ConfigurationProperties(prefix="spring.datasource")
//	public DruidDataSource druidDataSource(){
//		return new DruidDataSource();
//	}
	
	/**
     * 需要将 DataSourceProxy 设置为主数据源，否则seata事务无法回滚
     *
     * @param druidDataSource The DruidDataSource
     * @return The default datasource
     */
//	@Bean("dataSource")
//	@Primary
//	public DataSource dataSource(DataSource dataSource){
//		return new DataSourceProxy(dataSource); 
//	}
	

}
