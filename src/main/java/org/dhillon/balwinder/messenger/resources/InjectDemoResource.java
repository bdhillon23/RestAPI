package org.dhillon.balwinder.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	
	@GET
	@Path("/anotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam){
		return "The Matrix param is :" +matrixParam;
	}
}
