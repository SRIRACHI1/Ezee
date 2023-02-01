package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.userservice.model.UserModel;
import com.example.userservice.repository.UserRepository;

@Service
public class MyUserService {
	@Autowired
	private UserRepository userRepository;
	public List<UserModel> getAllUsers()
	{
	List<UserModel> users=new ArrayList<>();
	userRepository.findAll()
	.forEach(users::add);
	return users;
	}


	public void add(UserModel um)
	{
	userRepository.save(um);
	}

	public void Update(String userid, UserModel um) {
	userRepository.save(um);


	}



	public void delete(UserModel um) {
	// TODO Auto-generated method stub
	userRepository.delete(um);
	}


	

	
}
