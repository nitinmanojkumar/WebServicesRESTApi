package org.Myweb.showroom.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.Myweb.showroom.model.ErrorPayLoad;

// This annotation should be used to register this class as mapper for exception handling
// Based on the exception being used in resource classes, respective interface implemented in the class will be invoked
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>{

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorPayLoad error=new ErrorPayLoad(404,"Page Not Found");
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}