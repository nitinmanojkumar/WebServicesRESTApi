package org.Myweb.showroom.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.Myweb.showroom.model.Brands;
import org.Myweb.showroom.model.Link;
import org.Myweb.showroom.model.Products;
import org.Myweb.showroom.services.BrandService;
import org.Myweb.showroom.services.ProductService;

@Path("/showroom/brands")
public class BrandsResource {

	BrandService service = new BrandService();

	/*
	 
	@GET()
	@Path("/sample")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBrands1() {
		return "String";
	}

	@GET()
	@Path("/sample2")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getBrands2() {
		List<String> list=new ArrayList();
		list.add("hey");list.add("hello");
		return list;
	}

	*/
	
	@GET()
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brands> getBrands() {
		System.out.println("Inside Brands class inside get method");
		List<Brands> list = service.getBrands();
		return list;
	}

	@GET()
	@Path("/{brandID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Brands getBrand(@PathParam("brandID") int brandId, @Context UriInfo uri) {
		Link self=new Link(uri.getAbsolutePath().toString(),"self");
		Link products=new Link(uri.getAbsolutePathBuilder().path("products").build().toString(),"products");
		Brands brand=service.getBrand(brandId);
		List<Link> links=new ArrayList();
		links.add(self);
		links.add(products);
		brand.setLinks(links);
		//brand.setLinks(link);
		return brand;
		
	}
	
	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrands(Brands brand, @Context UriInfo uri) {
		
		service.addBrand(brand);
		URI location=uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
		//return Response.status(Status.CREATED).entity(brand).build();
		return Response.created(location).entity(brand).build();
	}

	@PUT()
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrands(@PathParam("brandId") int brandId, Brands updatedBrand) {
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}

	@DELETE()
	@Path("/{brandId}")
	public void deleteBrands(@PathParam("brandId") int brandId) {
		service.deleteBrand(brandId);
	}
	
	/*@Path("/{brandId}/products")
	public Products productDelegation() {
		return new Products();
	}*/

	
}
