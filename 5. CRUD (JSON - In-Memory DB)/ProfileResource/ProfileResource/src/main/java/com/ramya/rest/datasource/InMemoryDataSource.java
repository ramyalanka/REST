package com.ramya.rest.datasource;

import java.util.HashMap;
import java.util.Map;

import com.ramya.rest.model.Message;
import com.ramya.rest.model.Profile;

public class InMemoryDataSource {
	
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
