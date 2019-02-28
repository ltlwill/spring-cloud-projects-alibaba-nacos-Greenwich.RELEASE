package com.efe.ms.zuulgateway;

import java.util.regex.Pattern;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest{
	
	@Test
	public void test1(){
		String path = "/dddd/**";
		System.out.println(path.replaceAll("\\*\\*", "v2/api-docs"));
	}
	
	@Test
	public void test2(){
		Pattern pattern = Pattern.compile("\\w*(-route)$|config-server");
		System.out.println(pattern.matcher("config-server").matches());
	}
}
