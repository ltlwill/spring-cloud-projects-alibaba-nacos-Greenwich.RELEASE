package com.efe.ms.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class GatewayApplicationSecurityConfig {
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(
			ServerHttpSecurity http) {
		http.authorizeExchange().anyExchange().permitAll();
		/*http.authorizeExchange().anyExchange().authenticated().and()
				.httpBasic().and().formLogin();*/
		return http.build();
	}

	/*@Bean
	public MapReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user")
				.password("password").roles("USER").build(); // webflux自定义用户密码
		return new MapReactiveUserDetailsService(user);
	}*/

}
