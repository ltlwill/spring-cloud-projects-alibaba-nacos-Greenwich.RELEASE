package com.efe.ms.inventoryservice.service;

/**
 * 库存业务接口
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:56:42
 */
public interface InventoryService {
	
	/**
	 * 扣减库存
	 * @param sku
	 * @param count
	 */
	void deduct(String sku,Integer count);

}
