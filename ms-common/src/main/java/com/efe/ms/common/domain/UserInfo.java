package com.efe.ms.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo extends BusinessEntity{
	
	private String id;
	
	private String name;
	
	private String chName;
	
	private String enName;
	
	private Integer age;
	
	private String password;

}
