package com.efe.ms.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efe.ms.inventoryservice.service.InventoryService;

/**
 * 库存控制器
 * @author TianLong Liu
 * @date 2019年8月7日 上午10:40:24
 */

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/deduct")
	public boolean deduct(String sku,int count) throws Exception{
		inventoryService.deduct(sku, count);
		return true;
	}
	
}
