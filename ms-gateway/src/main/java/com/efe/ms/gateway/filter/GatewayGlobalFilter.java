package com.efe.ms.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * Spring Gateway 网关全局过来传奇
 * 
 * @author Liu TianLong
 * @2019年2月27日 下午5:42:58
 *
 */
@Component
public class GatewayGlobalFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange,
			GatewayFilterChain chain) {
		return chain.filter(exchange);
	}

}
