package com.efe.ms.orderservice.service;


/**
 * 订单业务接口
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:56:42
 */
public interface OrderService {
	
	/**
	 * 创建订单
	 * @param sku
	 * @param count
	 * @param amount
	 */
	void createOrder(String userId,String sku,Integer count);

}
