package org.Myweb.showroom.services;

import java.util.List;

import org.Myweb.showroom.model.Brands;
import org.Myweb.showrrom.DAO.BrandsDAO;

public class BrandService {

	BrandsDAO DAO=new BrandsDAO();
	
	public List<Brands> getBrands() {
		System.out.println("Inside getBrands : ");
		List<Brands> list=DAO.getBrands();
		System.out.println("Inside getBrands : "+ list);
		return list;
	}

	public void addBrand(Brands brand) {
		DAO.addBrand(brand);
		
	}

	public void updateBrand(Brands updatedBrand) {
		DAO.updateBrand(updatedBrand);
		
	}

	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);
		
	}

	public Brands getBrand(int brandId) {
		return DAO.getBrand(brandId);
	}

}
