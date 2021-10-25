package com.prebootcamp.bootcamppracticetwo.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductDaoService service;
	
	@GetMapping("/getsortProducts")
	public List<Product> getAllSortedProduct(){
		logger.info("sortProducts get method endpoint triggred");
		return service.getSortedProduct();
	}
	

	@PostMapping("/sortProducts")	
	public Map<String,List<Product>> getSortedProduct(@RequestBody Map<String,List<Product>> productmap){
		logger.info("sortProducts post method endpoint triggred");
		Map response = new HashMap<String, List<Product>>();
		response.put("sortedProductList", service.getSortedProduct(productmap.get("productList")));
		return response; }
	
	

}
