package com.efe.ms.zuulgateway.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.efe.ms.common.domain.UserInfo;
import com.efe.ms.common.util.UserInfoUtil;

/**
 * 全局web过滤器，每次请求都设置传递当前的用户信息
 * 
 * @author liutianlong
 *
 */
@WebFilter(filterName="zuulGatewayWebFilter",urlPatterns="/*")
@Order(0)
public class ZuulGatewayWebFilter implements Filter {
	private final static Logger logger = LoggerFactory
			.getLogger(ZuulGatewayWebFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		setTransferUserInfo((HttpServletRequest)request);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	private void setTransferUserInfo(HttpServletRequest request){
		logger.info("---ZuulGatewayWebFilter.setTransferUserInfo---");
		try{
			UserInfo user = new UserInfo();
			user.setId("10001");
			user.setName("test");
			UserInfoUtil.setUserInfo(user);
		}catch(Exception e){
			logger.error("ZuulGatewayWebFilter 设置传递user信息失败",e); 
		}
		
	}

}
