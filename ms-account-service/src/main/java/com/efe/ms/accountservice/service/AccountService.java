package com.efe.ms.accountservice.service;

import java.math.BigDecimal;

/**
 * 库存业务接口
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:56:42
 */
public interface AccountService {
	
	/**
	 * 扣减账户余额
	 * @param userId
	 * @param num
	 */
	void debit(String userId,BigDecimal num);

}
