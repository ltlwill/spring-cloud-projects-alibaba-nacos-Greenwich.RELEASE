package com.efe.ms.gateway.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * 
 * <p>
 * spring cloud gateway 服务文档聚合:
 * </p>
 * 
 * @author Liu TianLong 2018年10月4日 上午10:32:57
 */
@Component
@Primary
public class GatewayAggregationSwaggerResourcesProvider implements
		SwaggerResourcesProvider {

	public static final String SWAGGER_DOCS_PATH = "v2/api-docs";
	private static final String REPLACE_PATTERN = "\\*\\*";
	private static final String SWAGGER_VERSION = "2.0";
	private static final Pattern IGNORE_PATH_PATTERN = Pattern
			.compile("config-server|\\w*(-route)$",Pattern.CASE_INSENSITIVE);
	private static final Pattern AGGREATION_PATH_PATTERN = Pattern
			.compile("\\w*(-service)$|\\w*(-consumer)$",Pattern.CASE_INSENSITIVE); // 需要生成文档的服务名称正则表达式
	private static final Pattern NOT_AGGREATION_PATH_PATTERN = Pattern
			.compile("\\w*(-server)$",Pattern.CASE_INSENSITIVE);  // 不需要生成文档的服务名称正则表达式
	
	private final RouteLocator routeLocator;
	private final GatewayProperties gatewayProperties;

	@Autowired
	private DiscoveryClient discoveryClient;

	public GatewayAggregationSwaggerResourcesProvider(
			RouteLocator routeLocator, GatewayProperties gatewayProperties) {
		this.routeLocator = routeLocator;
		this.gatewayProperties = gatewayProperties;
	}

	/*
	 * @Override public List<SwaggerResource> get() { List<SwaggerResource>
	 * resources = new ArrayList<SwaggerResource>(); List<Route> routes = new
	 * ArrayList<Route>(); routeLocator.getRoutes().subscribe(route -> {
	 * route.getPredicate(). routes.add(route); System.out.println(route); });
	 * // routes.stream().filter(route ->
	 * AGGREATION_PATH_PATTERN.matcher(route.getId()).matches()) //
	 * .forEach(route -> route.getPredicate().); return resources; }
	 */

	@Override
	public List<SwaggerResource> get() {
		/** 方式1： **/
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		Optional.ofNullable(discoveryClient.getServices())
				.get()
				.stream()
				.filter(serviceName -> AGGREATION_PATH_PATTERN.matcher(
						serviceName).matches())
				.forEach(
						serviceName -> resources.add(swaggerResources(
								serviceName, "/" + serviceName + "/" + SWAGGER_DOCS_PATH)));
		
		/** 方式2： 完全没用 **/
        /*List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                        .forEach(predicateDefinition -> resources.add(swaggerResources(routeDefinition.getId(),
                                predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                        .replace("/**", SWAGGER_DOCS_PATH)))));*/

		return resources;
	}

	private SwaggerResource swaggerResources(String name, String location) {
		SwaggerResource resource = new SwaggerResource();
		resource.setName(name);
		resource.setLocation(location);
		resource.setSwaggerVersion(SWAGGER_VERSION);
		return resource;
	}
}
