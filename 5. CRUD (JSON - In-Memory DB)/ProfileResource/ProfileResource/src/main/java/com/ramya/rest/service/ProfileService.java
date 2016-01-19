package com.ramya.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ramya.rest.datasource.InMemoryDataSource;
import com.ramya.rest.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = InMemoryDataSource.getProfiles();
	
	public ProfileService() {
		profiles.put("rlanka", new Profile(1L, "rlanka", "Ramya", "Lanka"));
		profiles.put("ssoni", new Profile(2L, "ssoni", "Sunny", "Soni"));	
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String userName) {
		return profiles.get(userName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getUserName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getUserName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String userName) {
		Profile message = profiles.get(userName);
		profiles.remove(userName);
		return message;
	}
}
