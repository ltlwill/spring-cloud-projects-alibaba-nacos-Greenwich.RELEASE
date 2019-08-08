package com.efe.ms.accountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.efe.ms.accountservice.domain.Account;

/**
 * 库存dao
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:52:05
 */
public interface AccountRepository extends JpaRepository<Account,Long>,JpaSpecificationExecutor<Account>{
	
//	@Query(value="select a.id,a.user_id,a.balance from ms_account a where user_id = ?1",nativeQuery=true)
	@Query(value="select a from Account a where userId = ?1")
	Account findByUserId(String userId);

}
