package org.ass.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="product_info")
public class ProductEntity implements Serializable 
{
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator="auto")
	@Column(name="alt_key")
	private long altKey;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="discription")
	private String discription;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	

	@Override
	public String toString() {
		return "ProductEntity [altKey=" + altKey + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", discription=" + discription + "]";
	}
}
