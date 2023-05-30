package org.ass.product.Controller;

import java.util.List;

import org.ass.product.Service.ProductService;
import org.ass.product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController
{
	@Autowired
	private ProductService service;
	
	@GetMapping(value="/getAllUser")
	public @ResponseBody List<ProductEntity> getAllUser()
	{
		return service.getAllUser();
	}
	
	@PostMapping(value="/saveRegisterDetails")
	public void saveRegisterDetails(@RequestBody ProductEntity productEntity )
	{
		service.createProduct(productEntity);
	}
	@GetMapping(value="/getByID/{id}")
	public @ResponseBody ProductEntity getByID(@PathVariable("id") long id)
	{
		return service.getById(id);
	}
	@GetMapping(value="/getProductByName")
	public @ResponseBody List<ProductEntity> getProductByName(@RequestParam("name") String name)
	{
		return service.getByName(name);
	}
	@GetMapping(value="/deleteById/{id}")
	public ProductEntity deleteById(@PathVariable("id") long id)
	{
		return service.deleteById(id);
	}
	@GetMapping(value="/PriceRange/{minPrice}/{maxPrice}")
	public @ResponseBody List<ProductEntity> PriceRange(
			@PathVariable("minPrice") double minPrice,
			@PathVariable("maxPrice") double maxprice)
	{
		return service.productPriceRange(minPrice, maxprice);
	}
	
	@GetMapping("/findProductPriceByProductId/{productId}")
	public double findProductPriceByProductId(@PathVariable("productId") long productId)
	{
		System.out.println("productId :"+productId);
		return 230.40;
	}
}
