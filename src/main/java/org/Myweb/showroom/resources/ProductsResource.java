package org.Myweb.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.Myweb.showroom.model.Products;
import org.Myweb.showroom.services.ProductService;

@Path("/showroom/brands")
public class ProductsResource {

	ProductService productService = new ProductService();

	@GET()
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> getProducts(
			@PathParam("brandId") int brandId, 
			@QueryParam("category") String category,
			@QueryParam("start") int start,
			@QueryParam("size") int size
			) {
		System.out.println("inside me" + brandId);
		List<Products> productlist;
		if (category!=null) {
			productlist = productService.getProductsByBrandandCategory(brandId,category);
		} else {
			productlist = productService.getProducts(brandId);
		}
		if(size >0 && size<productlist.size()) {
			System.out.println("inside list substring");
			productlist=productlist.subList(start, size);
		}

		System.out.println("before returning");
		return productlist;
	}

}
