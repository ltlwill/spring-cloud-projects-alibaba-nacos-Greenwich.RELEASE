package com.efe.ms.zuulgateway.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
