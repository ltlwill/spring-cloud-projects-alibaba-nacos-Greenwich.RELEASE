package com.efe.ms.inventoryservice.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.efe.ms.inventoryservice.dao.InventoryRepository;
import com.efe.ms.inventoryservice.domain.Inventory;

/**
 * 库存业务实现类
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:57:38
 */
@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	@LcnTransaction // 分布式事务注解
	@Transactional(rollbackFor = Exception.class)
	public void deduct(String sku, Integer count) {
		if(StringUtils.isBlank(sku) || count <= 0){
			throw new IllegalArgumentException("扣减库存失败");
		}
		Inventory inventory = inventoryRepository.findBySku(sku);
		if(inventory == null || inventory.getCount() < count){
			throw new RuntimeException("库存不足");
		}
		inventory.setCount(inventory.getCount() - count);
		inventoryRepository.save(inventory);
	}
	
	
}
