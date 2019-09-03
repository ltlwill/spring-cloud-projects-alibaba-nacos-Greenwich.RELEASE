package com.efe.ms.zuulgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.efe.ms.zuulgateway.filter.UserInfoPreSettingFilter;

/**
 * 
 * @author TianLong Liu
 * @date 2019年8月30日 下午5:55:56
 */
@Configuration
public class FilterConfig {
	
	/*@Bean
	public UserInfoTransferFilter userInfoTransferFilter(){
		return new UserInfoTransferFilter();
	}*/
	
	@Bean
	public UserInfoPreSettingFilter userInfoPreSettingFilter(){
		return new UserInfoPreSettingFilter();
	}

}
