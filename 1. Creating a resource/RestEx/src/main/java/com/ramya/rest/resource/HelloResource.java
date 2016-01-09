package com.ramya.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value="message/welcome")
public class HelloResource {
	
	@GET
	@Path(value="hello")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String sayHello() {	/*	/v1/RestEx/v1/message/welcome/hello     */
		return "Hello Ramya";
	}
	
	@GET
	@Path(value="hi")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String sayHi() {	/*	/v1/RestEx/v1/message/welcome/hi     */
		return "Hi Ramya";
	}
}
