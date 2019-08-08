package com.efe.ms.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efe.ms.orderservice.service.OrderService;

/**
 * 库存控制器
 * @author TianLong Liu
 * @date 2019年8月7日 上午10:40:24
 */

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/create")
	public boolean create(String userId,String sku,int count) throws Exception{
		orderService.createOrder(userId, sku, count); 
		return true;
	}
	
}
