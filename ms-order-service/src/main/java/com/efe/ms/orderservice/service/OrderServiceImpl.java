package com.efe.ms.orderservice.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efe.ms.orderservice.dao.OrderRepository;
import com.efe.ms.orderservice.domain.Order;
import com.efe.ms.orderservice.feign.AccountServiceFeiClient;

/**
 * 订单业务实现类
 * @author TianLong Liu
 * @date 2019年7月30日 下午3:57:38
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AccountServiceFeiClient accountServiceFeiClient;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void createOrder(String userId, String sku, Integer count) {
		if(StringUtils.isBlank(userId) || StringUtils.isBlank(sku) || count == null || count <= 0){
			throw new RuntimeException("创建订单失败，参数无效");
		}
		BigDecimal amount = new BigDecimal(count).multiply(new BigDecimal(5));
		
		Order order = new Order();
		order.setUserId(userId);
		order.setSku(sku);
		order.setCount(count);
		order.setAmount(amount);
		order.setCreateTime(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		
		orderRepository.save(order); // 生成订单
		accountServiceFeiClient.debit(userId, amount); // 从账户扣钱
	}
}
