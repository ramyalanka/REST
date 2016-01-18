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
	public String showAllMessages() {	
		return "Messages are displayed";
	}
	
	@GET
	@Path(value="/{msgId}")
	@Produces(value=MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam(value="msgId") long id){
		return new Message(1, "This is msg", new Date(), "Ramu");
	}
	
	@POST
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Produces(value=MediaType.APPLICATION_XML)
	public Message createMessage(Message message){
		return message;
	}
	
	@DELETE
	@Path(value="/{msgId}")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam(value="msgId") long id){
		return "message is deleted of ID :" + id;
	}
	
	@PUT
	@Path(value="/{msgId}")
	@Consumes(value=MediaType.APPLICATION_XML)
	@Produces(value=MediaType.TEXT_PLAIN)
	public String updateMessage(Message message, @PathParam(value="msgId") long id){
		return "message is updated of ID :" + id;
	}
	
	
}
