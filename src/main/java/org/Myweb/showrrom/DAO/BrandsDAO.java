package org.Myweb.showrrom.DAO;

import java.util.List;

import org.Myweb.showroom.model.Brands;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BrandsDAO {

	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Brands.class)
			.buildSessionFactory();
			
	
	public List<Brands> getBrands() {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("BrandsDAO getBrands1");
		List<Brands> list=session.createQuery("from brands").getResultList();
		System.out.println("BrandsDAO getBrands2");
		return list;
	}
	
	public Brands getBrand(int brandId) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		return session.get(Brands.class, brandId);
	}

	public void addBrand(Brands brand) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		
	}

	public void updateBrand(Brands updatedBrand) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		int id=updatedBrand.getBrandId();
		Brands brand=session.get(Brands.class, id);
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Brands brand=session.get(Brands.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();
		
	}

	
	
}
