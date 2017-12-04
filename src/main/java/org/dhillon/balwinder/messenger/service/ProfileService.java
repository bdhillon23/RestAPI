package org.dhillon.balwinder.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dhillon.balwinder.messenger.database.DatabaseClass;
import org.dhillon.balwinder.messenger.model.Message;
import org.dhillon.balwinder.messenger.model.Profile;

public class ProfileService {

private Map<String, Profile> profiles=DatabaseClass.getProfile();
	
	public ProfileService(){
		profiles.put("bdhillon", new Profile(1, "bdhillon", "balwinder", "Dhillon"));
		profiles.put("sdhillon", new Profile(2, "Sdhillon", "Surender", "Dhillon"));
		
	}
	public List<Profile> getAllProfiles(){
	return new ArrayList<Profile>(profiles.values());
	}
	
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
		
}
