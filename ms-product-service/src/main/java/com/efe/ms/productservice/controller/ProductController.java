package com.efe.ms.productservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.efe.ms.common.domain.UserInfo;
import com.efe.ms.common.util.UserInfoUtil;
import com.efe.ms.productservice.domain.Combo;
import com.efe.ms.productservice.domain.Product;
import com.efe.ms.productservice.service.ProductService;
import com.efe.ms.productservice.vo.Pagination;

/**
 * 
 * <p>
 * 产品控制器:
 * </p>
 * 
 * @author Liu TianLong 2018年10月9日 上午10:28:47
 */
@Api(tags = "产品API")
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	
	 /*@ApiOperation(value = "分页获取产品信息")
	 @GetMapping()
	 public Pagination<Product> getAllProducts(Pagination<Product> page, Product product) { 
		 return productService.getAllProducts(page, product); 
	 }*/
	 

	@ApiOperation(value = "分页获取产品信息")
	@GetMapping
	public Pagination<Product> getAllProductsByPage(Integer pageNo,Integer pageSize,Product product) {
		return productService.getAllProductsByPage(pageNo, pageSize, product);
	}

	@ApiOperation(value = "根据SKU获取产品信息")
	@GetMapping("/{sku}")
	public Product getProductBySku(@PathVariable String sku) {
		UserInfo user = UserInfoUtil.getUserInfo();
		System.out.println("--user--:" + (user == null ? null : JSON.toJSONString(user)));
		return productService.getProductBySku(sku);
	}

	@ApiOperation(value = "根据SKU获取产品的组合信息")
	@GetMapping("/combo/{sku}")
	public List<Combo> getComboListBySku(@PathVariable String sku) {
		return productService.getComboListBySku(sku);
	}

	@ApiOperation(value = "根据SKU获取产品的组合信息中的所有SKU")
	@GetMapping("/combo/skus/{sku}")
	public List<String> getComboSkusBySku(@PathVariable String sku) {
		return productService.getComboSkusBySku(sku);
	}

	@ApiOperation(value = "根据SKU获取主SKU")
	@GetMapping("/combo/main/{sku}")
	public String getMainSku(@PathVariable String sku) {
		return productService.getMainSku(sku);
	}
}
