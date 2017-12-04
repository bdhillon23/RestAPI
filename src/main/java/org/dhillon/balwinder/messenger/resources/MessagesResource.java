package org.dhillon.balwinder.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dhillon.balwinder.messenger.model.Message;
import org.dhillon.balwinder.messenger.service.MessageService;


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessagesResource {
MessageService ms=new MessageService();
	
@GET 

public List<Message> getMessages(){
		return ms.getAllMessages();
	}

@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public Message getMessage(@PathParam("messageId") Long messageId){
return	ms.getMessage(messageId);
}

@POST
public Message addMessage(Message message){
	
	return ms.addMessage(message);
}

@PUT
@Path("/{messageId}")
public Message updateMessage(@PathParam("messageId")long messageId,Message message){
	message.setId(messageId);
	return ms.updateMessage(message);
}

@DELETE
@Path("/{messageId}")
public Message removeMessage(@PathParam("messageId")Long messageId){
	return ms.removeMessage(messageId);
}


}



