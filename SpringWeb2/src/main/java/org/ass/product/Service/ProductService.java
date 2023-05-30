package org.ass.product.Service;

import java.util.List;

import org.ass.product.entity.ProductEntity;
import org.ass.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository repository;
	
	public void createProduct(ProductEntity product)
	{
		repository.saveProduct(product);
	}
	
	public List<ProductEntity> getAllUser()
	{
		return repository.getAllUser();
	}
	public ProductEntity getById(long id)
	{
		return repository.getById(id);
	}
	public List<ProductEntity>getByName(String name)
	{
		return repository.getProductByName(name);
	}
	
	public ProductEntity deleteById(long id)
	{
		return repository.DeleteById(id);
	}
	
	public List productPriceRange(double minPrice,double maxPrice)
	{
		return repository.productPriceRange(minPrice, maxPrice);
	}
}
