package org.ass.product.repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.ass.product.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

@Repository
public class ProductRepository 
{
	@Autowired
	private SessionFactory factory;
	
	public void saveProduct(ProductEntity product)
	{
		Session session = factory.openSession();
		Transaction transcation = session.beginTransaction();
		Serializable save = session.save(product);
		System.out.println(save);
		transcation.commit();
	}
	public List<ProductEntity> getAllUser()
	{
		try {
			String hqlQuery="from ProductEntity";
			Session session = factory.openSession();
			Query query = session.createQuery(hqlQuery);
			return query.getResultList();
		}catch(Exception e) {
			return Collections.EMPTY_LIST;
		}
	}
	
	public ProductEntity getById(long id)
	{
		try {

			Session session = factory.openSession();
			ProductEntity product = session.get(ProductEntity.class, id);
			return product;
			
		}catch(Exception e) {
			
		}
		return null;
	}
	public List<ProductEntity> getProductByName(String name)
	{
		try {
			Session session = factory.openSession();
			Transaction transcation = session.beginTransaction();
			Query query = session.createQuery("from ProductEntity where name=:pname");
			Query setParameter = query.setParameter("pname", name);
			return setParameter.getResultList();
		}catch(Exception e) {
			
		}
		return null;
	}
	public ProductEntity DeleteById(long id)
	{
		try {
			Session session = factory.openSession();
			Transaction transcation = session.beginTransaction();
			ProductEntity pid = session.get(ProductEntity.class, id);
			session.delete(pid);
			transcation.commit();
			return pid;
		}catch(Exception e) {
			
		}
		return null;
	}
	public List<ProductEntity> productPriceRange(double minPrice,double maxPrice)
	{   
		Session session = factory.openSession();
		Transaction transcation = session.beginTransaction();
		Query query = session.createQuery(" FROM ProductEntity WHERE price BETWEEN :minPrice AND :maxPrice");
		query.setParameter("minPrice", minPrice);
		query.setParameter("maxPrice", maxPrice);
		List list = query.list();
		return list;
	}
}
