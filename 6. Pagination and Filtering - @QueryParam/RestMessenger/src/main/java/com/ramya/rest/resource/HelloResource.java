package com.ramya.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ramya.rest.model.Message;
import com.ramya.rest.service.MessageService;


@Path(value="message")
public class HelloResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Message> getMessages( @QueryParam("author") String author,
										@QueryParam("start") int start,
										@QueryParam("size") int size) {
		if(author!=null && !author.isEmpty()) 
			return messageService.getMessagesByAuthor(author);
		if(start>0 && size>0) 
			return messageService.getMessagesPaginated(start, size);
		return messageService.getMessages();
	}
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	@Path(value="/{msgId}")
	public Message getMessage(@PathParam(value="msgId") long id) {
		return messageService.getMessage(id);
	}
	
	@POST
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Path(value="/{msgId}")
	public Message updateMessage(Message message, @PathParam(value="msgId") long id) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Produces(value=MediaType.APPLICATION_JSON)
	@Path(value="/{msgId}")
	public Message removeMessage(@PathParam(value="msgId") long id) {
		return messageService.removeMessage(id);
	}
	
}
