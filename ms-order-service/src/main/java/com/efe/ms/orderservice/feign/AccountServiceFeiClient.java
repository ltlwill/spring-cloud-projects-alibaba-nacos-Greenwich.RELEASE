package com.efe.ms.orderservice.feign;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * account 服务的feign 客户端
 * @author TianLong Liu
 * @date 2019年8月8日 下午5:47:29
 */

@FeignClient(name="account-service")
public interface AccountServiceFeiClient {

	/**
	 * 扣减账户余额
	 * @param userId
	 * @param num
	 * @return
	 */
	@GetMapping("/account/debit")
	boolean debit(@RequestParam("userId")String userId,@RequestParam("num")BigDecimal num); 
}
