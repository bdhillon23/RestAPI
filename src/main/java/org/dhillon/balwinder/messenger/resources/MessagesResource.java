package org.dhillon.balwinder.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.dhillon.balwinder.messenger.beanObject.MessageFilterBean;
import org.dhillon.balwinder.messenger.exception.DataNotFoundException;
import org.dhillon.balwinder.messenger.model.Message;
import org.dhillon.balwinder.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessagesResource {
	MessageService ms = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterbean) {
		
		if(filterbean.getYear() >0){
			return ms.getAllMessageForYear(filterbean.getYear());
		}
		if(filterbean.getStart() >0 && filterbean.getSize() >0){
			return ms.getAllMessagePaginated(filterbean.getStart() , filterbean.getSize());
		}
		return ms.getAllMessages();
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long messageId,
			@Context UriInfo uri) {
		Message message= ms.getMessage(messageId);
		
		if(message==null){
			throw new DataNotFoundException("Message with Id: "+messageId+" not found"); 
		}
		
		message.addLink(getURLforSelf(uri, message), "self");
		
		return message;
		
		
	}

	private String getURLforSelf(UriInfo uri, Message message) {
		String URL=uri.getBaseUriBuilder()
				.path(MessagesResource.class)
				.path(Long.toString(message.getId()))
				.build()
				.toString();
		return URL;
	}

	@POST
	public Response addMessage(Message message) {
		Message newMessage=ms.addMessage(message);
	return	Response.status(Status.CREATED)
		.entity(newMessage).build();
		//return ms.addMessage(message) ;
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId,
			Message message) {
		message.setId(messageId);
		return ms.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") Long messageId) {
		return ms.removeMessage(messageId);
	}

}
