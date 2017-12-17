package org.dhillon.balwinder.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.dhillon.balwinder.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage er=new ErrorMessage("DataNotFoundException", 404, "http://www.google.com");
		return Response.status(Status.NOT_FOUND)
				.entity(er)
				.build();
	}

}
