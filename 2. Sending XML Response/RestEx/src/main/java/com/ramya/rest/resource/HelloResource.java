package com.ramya.rest.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ramya.rest.model.Message;


@Path(value="welcome")
public class HelloResource {
	
	@GET
	@Path(value="message")
	@Produces(value=MediaType.APPLICATION_XML)
	public Message showMessage() {	
		return new Message(1, "Hi", new Date(), "Ramya");
	}
	
}
