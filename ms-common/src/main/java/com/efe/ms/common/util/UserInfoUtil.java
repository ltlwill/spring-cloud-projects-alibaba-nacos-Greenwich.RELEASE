package com.efe.ms.common.util;

import com.efe.ms.common.domain.UserInfo;

/**
 * 
 * @author TianLong Liu
 * @date 2019年8月30日 上午9:34:41
 */
public final class UserInfoUtil {
	
	private static final ThreadLocal<UserInfo> userInfoHolder = new InheritableThreadLocal<>();
	private static final ThreadLocal<String> userIdHolder = new InheritableThreadLocal<>();
	
	public static UserInfo getUserInfo(){
		return userInfoHolder.get();
	}
	
	public static void setUserInfo(UserInfo userInfo){
		userInfoHolder.set(userInfo);
	}
	
	public static String getUserId(){
		return userIdHolder.get();
	}
	
	public static void setUserId(String userId){
		userIdHolder.set(userId);
	}

}
