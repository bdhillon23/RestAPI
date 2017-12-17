package org.dhillon.balwinder.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.dhillon.balwinder.messenger.model.ErrorMessage;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage er=new ErrorMessage(ex.getMessage(), 500, "documentation");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
		.entity(er)
		.build();
	}

}
