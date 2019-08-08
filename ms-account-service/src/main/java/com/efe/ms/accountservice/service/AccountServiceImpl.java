package com.efe.ms.accountservice.service;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efe.ms.accountservice.dao.AccountRepository;
import com.efe.ms.accountservice.domain.Account;

/**
 * 库存业务实现类
 * 
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:57:38
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void debit(String userId, BigDecimal num) {
		if (StringUtils.isBlank(userId) || num == null) {
			throw new RuntimeException("扣减账户余额失败，参数无效");
		}
		Account account = accountRepository.findByUserId(userId);
		if (account == null) {
			throw new RuntimeException(String.format("账户不存在，账户ID：%s", userId));
		}
		if (account.getBalance() == null
				|| account.getBalance().compareTo(num) == -1) {
			throw new RuntimeException(String.format("账户余额不足，余额：%d，应扣除金额：%d",
					account.getBalance() == null ? 0 : account.getBalance(),
					num));
		}
		account.setBalance(account.getBalance().subtract(num));
		accountRepository.save(account);
	}
}
