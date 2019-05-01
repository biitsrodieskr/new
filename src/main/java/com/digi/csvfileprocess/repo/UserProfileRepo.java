package com.digi.csvfileprocess.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.digi.csvfileprocess.model.UserProfile;

public interface UserProfileRepo extends MongoRepository<UserProfile, String> {
	@Query("{ 'email_id' : ?0 }")
	public List<UserProfile> findByEmaiId(String emaiId);
}
