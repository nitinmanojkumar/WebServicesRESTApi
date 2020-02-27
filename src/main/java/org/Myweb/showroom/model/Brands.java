package org.Myweb.showroom.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@Entity(name="brands")
@Table(name="brands")
public class Brands {

	@Id
	// Display brand ID in response while posting a new brand
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brandId")//used to map variable name or annotation name with DB column by default in hibernate
	private int brandId;
	
	@Column(name="brandName")
	private String brandName;
	
	@Transient//used not to map variable name or annotation name with DB column which happens by default in hibernate
	private List<Link> links;
	
	/*@Transient//used not to map variable name or annotation name with DB column which happens by default in hibernate
	private Link link;
	
	public Link getLinks() {
		return links;
	}

	public void setLinks(Link links) {
		this.links = links;
	}*/
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Brands() {
		System.out.println("Inside BrandEntity constructor1");
	}

	public Brands(int brandId, String brandName) {
		super();
		System.out.println("Inside BrandEntity constructor2");
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getBrandId() {
		System.out.println("BrandEntity getBrandID");
		return brandId;
	}

	public void setBrandId(int brandId) {
		System.out.println("BrandEntity setBrandID");
		this.brandId = brandId;
	}

	public String getBrandName() {
		System.out.println("BrandEntity getBrandName");
		return brandName;
	}

	public void setBrandName(String brandName) {
		System.out.println("BrandEntity setBrandName");
		this.brandName = brandName;
	}
	
	
	
	
	
}
