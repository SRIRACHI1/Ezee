package com.casestudy.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.user.model.User;

@Repository
public interface UserRepository extends MongoRepository <User,Integer>
{
	User findByUsername(String username);

}
