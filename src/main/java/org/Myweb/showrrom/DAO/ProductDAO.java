package org.Myweb.showrrom.DAO;

import java.util.List;

import org.Myweb.showroom.model.Brands;
import org.Myweb.showroom.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

	SessionFactory factory=new Configuration().
			configure("hibernate.cfg.xml").
			addAnnotatedClass(Products.class).
			addAnnotatedClass(Brands.class).
			buildSessionFactory();
	
	public List<Products> getProducts(int brandId) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		String sql="from product where brandId = "+brandId;
		System.out.println("inside prod DAO1");
		List<Products> productlist=session.createQuery(sql).getResultList();
		for(Products var: productlist) {
			System.out.println(var.getProductId());
		}
		
		System.out.println("inside prod DAO2");
		return productlist;
	}

	public List<Products> getProductsByBrandandCategory(int brandId, String category) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		String sql="from product where brandId ="+brandId+" and category = '"+category+"'";
		List<Products> productList=session.createQuery(sql).getResultList();
		return productList;
	}

}
