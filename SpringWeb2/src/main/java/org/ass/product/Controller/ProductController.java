package org.ass.product.Controller;

import org.ass.product.Service.ProductService;
import org.ass.product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class ProductController
{
	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/createProduct")
	public ModelAndView createProduct(ProductEntity product)
	{
		service.createProduct(product);
		return new ModelAndView("index.jsp");
	}
}
