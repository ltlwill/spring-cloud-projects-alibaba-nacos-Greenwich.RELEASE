package com.efe.ms.zuulgateway.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.efe.ms.zuulgateway.utils.JWTUtil;

/**
 * 
 * @author TianLong Liu
 * @date 2019年8月30日 下午5:52:02
 */

@RestController
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		return "hello zuul.";
	}
	
	@RequestMapping("/login")
	public String login(String userId){
		if(StringUtils.isBlank(userId)){
			throw new RuntimeException();
		}
		return JWTUtil.createToken(userId);
	}
	
	@RequestMapping("verifyToken")
	public boolean verifyToken(String token){
		if(StringUtils.isBlank(token)) return false;
		DecodedJWT jwt = JWTUtil.verifyToken(token);
		return jwt != null;
	}

}
