package com.casestudy.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.user.model.ERole;
import com.casestudy.user.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	  Optional<Role> findByName(ERole name);
	}
