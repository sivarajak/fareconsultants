package com.sms.fareconsultant.rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sms.fareconsultant.rs.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findById(long id);
	
	User findByUserName(String userName);

}
