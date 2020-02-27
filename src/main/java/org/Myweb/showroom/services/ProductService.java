package org.Myweb.showroom.services;

import java.util.List;

import org.Myweb.showroom.model.Products;
import org.Myweb.showrrom.DAO.ProductDAO;

public class ProductService {

	ProductDAO DAO=new 	ProductDAO();

	public List<Products> getProducts(int brandId) {
		System.out.println("inside prod service1");
		List<Products> list=DAO.getProducts(brandId);
		System.out.println("inside prod service2");
		return list;
	}

	public List<Products> getProductsByBrandandCategory(int brandId, String category) {
		System.out.println("inside prod&cat service1");
		List<Products> list=DAO.getProductsByBrandandCategory(brandId,category);
		System.out.println("inside prod&cat service2");
		return list;
	}
	
	
}
