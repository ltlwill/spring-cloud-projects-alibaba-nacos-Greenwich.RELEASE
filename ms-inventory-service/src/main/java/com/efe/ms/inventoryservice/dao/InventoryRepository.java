package com.efe.ms.inventoryservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.efe.ms.inventoryservice.domain.Inventory;

/**
 * 库存dao
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:52:05
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long>,JpaSpecificationExecutor<Inventory>{
	
	@Query(value="select a from Inventory a where sku = ?1")
	Inventory findBySku(String sku);

}
