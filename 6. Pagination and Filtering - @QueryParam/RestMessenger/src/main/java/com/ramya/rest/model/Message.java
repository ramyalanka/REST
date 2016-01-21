package com.ramya.rest.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Getter @Setter @NoArgsConstructor
public class Message {
	
	public Message(long id, String message, String author){
		this.id = id;
		this.created = new Date();
		this.message = message;
		this.author = author;
	}
	
	private long id;
	private String message;
	private Date created;
	private String author;
}