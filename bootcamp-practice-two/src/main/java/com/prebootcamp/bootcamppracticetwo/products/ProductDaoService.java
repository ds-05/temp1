package com.prebootcamp.bootcamppracticetwo.products;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

//import com.prebootcamp.bootcamppracticeone.product.Product;



@Component
public class ProductDaoService {
	
	private static List<Product> productList = new ArrayList<>();
	
	static {
		try {
			productList
					.add(new Product("Prod6", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-21")));
			productList
					.add(new Product("Prod6", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21")));
			productList
					.add(new Product("Prod1", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21")));
			productList.add(
					new Product("Prod2", "Trousers", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19")));
			productList
					.add(new Product("Prod3", "Tie", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22")));
			productList
					.add(new Product("Prod3", "Tie", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-24")));
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	public List<Product> getSortedProduct()
	{
		List<Product> sortedList = productList.stream()
				.sorted(comparingByProductIdAndLaunchDate)
				.collect(Collectors.toList());
		
		return sortedList;
	}
	
	public List<Product> getSortedProduct(List<Product> product) 
	{

		List<Product> sortedList = product.stream()
		        .sorted(comparingByProductIdAndLaunchDate)
		        .collect(Collectors.toList());
		

		product.sort(comparingByProductIdAndLaunchDate);
		
		return product;
	}
	
	Comparator <Product> comparingByProductIdAndLaunchDate =
			Comparator.comparing(Product::getProductId)
						.thenComparing(Product::getLaunchDate).reversed();
	
	
}
