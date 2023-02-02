package com.casestudy.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.user.model.IdGenerator;

public interface IdRepository extends MongoRepository<IdGenerator , String>{

}
