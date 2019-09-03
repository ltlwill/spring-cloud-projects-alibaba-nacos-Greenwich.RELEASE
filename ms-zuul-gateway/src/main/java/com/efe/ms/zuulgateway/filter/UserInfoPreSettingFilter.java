package com.efe.ms.zuulgateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.efe.ms.common.constant.Constants;
import com.efe.ms.common.domain.UserInfo;
import com.efe.ms.common.util.UserInfoUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * zuul网关前置过滤器，增加传递当前登录用户的信息
 * @author TianLong Liu
 * @date 2019年8月30日 下午4:52:36
 */
public class UserInfoPreSettingFilter extends ZuulFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoPreSettingFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		constructCurrentUserInfo();
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
	private void constructCurrentUserInfo(){
		try{
			RequestContext context = RequestContext.getCurrentContext();
//			HttpServletRequest request = context.getRequest();
//			String token = request.getHeader(Constants.Headers.ACCESS_TOKEN);
//			String userId = request.getHeader(Constants.Headers.TANSFER_USER_ID);
			UserInfo user = new UserInfo();
			user.setId("10001");
			user.setName("test");
			UserInfoUtil.setUserInfo(user);
			context.addZuulRequestHeader(Constants.Headers.TANSFER_USER_INFO, JSON.toJSONString(user)); 
		}catch(Exception e){
			logger.error("ZullGatewayInterceptor 设置传递user信息失败",e); 
		}
		
	}

}
