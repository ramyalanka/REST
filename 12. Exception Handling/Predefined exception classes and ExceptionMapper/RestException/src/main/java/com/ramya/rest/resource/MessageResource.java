package com.ramya.rest.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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

import com.ramya.rest.exception.ErrorPage;
import com.ramya.rest.model.Message;
import com.ramya.rest.service.MessageService;

@Path(value="/messages")
@Produces(value=MediaType.APPLICATION_JSON)
@Consumes(value=MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages( @QueryParam("author") String author,
									@QueryParam("start") int start,
									@QueryParam("size") int size)
	{
		if(author!=null && !author.isEmpty()) 
			return messageService.getMessagesByAuthor(author);
		if(start>0 && size>0) 
			return messageService.getMessagesPaginated(start, size);
		return messageService.getMessages();
	}
	
	@GET
	@Path(value="/{msgId}")
	public Message getMessage(@PathParam(value="msgId") long id) {
		Message message = messageService.getMessage(id);
		if(message==null) {
			ErrorPage errorPage = new ErrorPage("Message with id : "+ id + " not found.", Status.NOT_FOUND.getStatusCode());
			Response response = Response
					.status(Status.NOT_FOUND)
					.entity(errorPage)
					.build();
			throw new NotFoundException("Not found exception occured", response);
		}
		return message;
	}
	
	/*@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}*/
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMsg = messageService.addMessage(message);
		/*Response response = Response
			.status(Status.CREATED)
			.header("Location", "/MessengerRest/v1/messages/"+newMsg.getId())
			.entity(newMsg)
			.build();*/

		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMsg.getId())).build();
		Response response = Response
				.created(uri)	// <--- This created(URI uri) method will send status code=201 & Location header = uri
				.entity(newMsg)
				.build();
		return response;
	}
	
	@PUT
	@Path(value="/{msgId}")
	public Message updateMessage(Message message, @PathParam(value="msgId") long id) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path(value="/{msgId}")
	public Message removeMessage(@PathParam(value="msgId") long id) {
		return messageService.removeMessage(id);
	}
	
	/************** Sub resource ***************/
	@Path(value="/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}