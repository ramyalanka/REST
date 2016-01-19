package com.ramya.rest.resource;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ramya.rest.model.Message;


@Path(value="message")
public class HelloResource {
	
	@GET
	@Produces(value=MediaType.TEXT_PLAIN)
	public String getMessages() {
		return "All messages displayed.";
	}
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	@Path(value="/{msgId}")
	public Message getMessage(@PathParam(value="msgId") long id) {
		return new Message(id, "Hi", new Date(), "Ramya");
	}
	
	@POST
	@Produces(value=MediaType.TEXT_PLAIN)
	@Consumes(value=MediaType.APPLICATION_JSON)
	public String createMessage(Message message) {
		return "Message added." + message.getMessage();
	}
	
	@PUT
	@Produces(value=MediaType.TEXT_PLAIN)
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Path(value="/{msgId}")
	public String updateMessage(Message message, @PathParam(value="msgId") long id) {
		return "Message(id : " + id + ") updated.";
	}

	@DELETE
	@Produces(value=MediaType.TEXT_PLAIN)
	@Path(value="/{msgId}")
	public String removeMessage(@PathParam(value="msgId") long id) {
		return "Message(id : "+id+") is removed.";
	}
	
	
}
