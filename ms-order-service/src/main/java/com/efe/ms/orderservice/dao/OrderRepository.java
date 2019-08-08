package com.efe.ms.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.efe.ms.orderservice.domain.Order;

/**
 * 库存dao
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:52:05
 */
public interface OrderRepository extends JpaRepository<Order,Long>,JpaSpecificationExecutor<Order>{
	
	@Query(value="select a from Order a where sku = ?1")
	Order findBySku(String sku);

}
