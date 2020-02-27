package org.Myweb.showroom.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.Myweb.showroom.model.ErrorPayLoad;

@Path("/")
public class DemoResource {

	@Context
	private UriInfo uriInfo;

	@Context
	private ServletContext servletContext;

	// when header section is provided with field headerAttribute with some value
	// and cookies are created
	@GET
	@Path("demo")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public String getAttribute(@HeaderParam("header") String header) throws Exception {
		ErrorPayLoad error = new ErrorPayLoad(404, "Not found");
		// Exception handler
		Response resp = Response.status(404).entity(error).build();
		if (header == null)
			throw new WebApplicationException(resp);
		return "headerAttribute :" + header;
	}

	// GENERIC Exception
	// Getting the response from mapper class
	@GET
	@Path("genericException")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public String genericException(@HeaderParam("header") String header) throws Exception {
		if (header == null)
			throw new Exception();
		return "The value of headerAttribute :" + header;
	}

	// Not found Exception
	// Getting the response from mapper class
	@GET
	@Path("NotFoundException")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public String notFoundException(@HeaderParam("header") String header) throws Exception {
		if (header == null)
			throw new NotFoundException();
		return "The value of headerAttribute :" + header;
	}

	// to get all the default headers attribute
	@GET
	@Path("demo1")
	@Produces(MediaType.TEXT_PLAIN)
	public String context(@Context HttpHeaders header) {
		return header.getRequestHeaders().keySet().toString();
	}

	// to get all the default headers value
	@GET
	@Path("demo2")
	@Produces(MediaType.TEXT_PLAIN)
	public String context1(@Context HttpHeaders header) {
		return header.getRequestHeaders().values().toString();
	}

	//
	@GET
	@Path("demo3")
	@Produces(MediaType.TEXT_PLAIN)
	public String usefulAnnotation() {
		return "Hey";
	}

}
