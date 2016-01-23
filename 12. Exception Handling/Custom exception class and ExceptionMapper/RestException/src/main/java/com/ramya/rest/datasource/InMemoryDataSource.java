package com.ramya.rest.datasource;

import java.util.HashMap;
import java.util.Map;

import com.ramya.rest.model.Message;

public class InMemoryDataSource {
	
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
}
