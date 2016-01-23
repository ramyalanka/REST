package com.ramya.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ramya.rest.datasource.InMemoryDataSource;
import com.ramya.rest.model.Comment;
import com.ramya.rest.model.Message;

public class CommentService {
private Map<Long, Message> messages = InMemoryDataSource.getMessages();
	
	public CommentService() {
	}
	
	public List<Comment> getComments(long messageId) {
		return new ArrayList<>(messages.get(messageId).getComments().values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Message message = messages.get(messageId);
		return message.getComments().get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Message message = messages.get(messageId);
		Map<Long, Comment>commentsMap = message.getComments();
		comment.setId(commentsMap.size()+1);
		commentsMap.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Message message = messages.get(messageId);
		Map<Long, Comment>commentsMap = message.getComments();
		commentsMap.put(comment.getId(), comment);
		return comment;
	}
	
	public void removeComment(long messageId, long commentId) {
		Message message = messages.get(messageId);
		Map<Long, Comment>commentsMap = message.getComments();
		commentsMap.remove(commentId);
	}
}
