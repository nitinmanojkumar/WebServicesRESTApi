package org.Myweb.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="product")
@Table(name="product")
public class Products {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	int productId;
	
	@ManyToOne(targetEntity=Brands.class)
	@JoinColumn(name="brandId")
	Brands brandEntity;
	
	@Column(name="productName")
	String productName;
	
	@Column(name="category")
	String category;
	
	@Column(name="cost")
	String cost;
	
	public Products() {
		System.out.println("inside productEntity constructor");
	}

	public int getProductId() {
		System.out.println("getProductId");
		return productId;
	}

	public void setProductId(int productId) {
		System.out.println("setProductId");
		this.productId = productId;
	}

	public Brands getBrandEntity() {
		System.out.println("getBrandEntity");
		return brandEntity;
	}

	public void setBrandEntity(Brands brandEntity) {
		System.out.println("setBrandEntity");
		this.brandEntity = brandEntity;
	}

	public String getProductName() {
		System.out.println("getProductName");
		return productName;
	}

	public void setProductName(String productName) {
		System.out.println("setProductName");
		this.productName = productName;
	}

	public String getCategory() {
		System.out.println("getCategory");
		return category;
	}

	public void setCategory(String category) {
		System.out.println("setCategory");
		this.category = category;
	}

	public String getCost() {
		System.out.println("getCost");
		return cost;
	}

	public void setCost(String cost) {
		System.out.println("setCost");
		this.cost = cost;
	}
	
}
