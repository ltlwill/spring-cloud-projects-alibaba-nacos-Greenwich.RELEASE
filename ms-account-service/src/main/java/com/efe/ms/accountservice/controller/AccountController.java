package com.efe.ms.accountservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efe.ms.accountservice.service.AccountService;

/**
 * 库存控制器
 * @author TianLong Liu
 * @date 2019年8月7日 上午10:40:24
 */

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/debit")
	public boolean debit(String userId,BigDecimal num) throws Exception{
		accountService.debit(userId, num);
		return true;
	}
	
}
