package com.casestudy.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.user.model.Product;
import com.casestudy.user.model.User;
import com.casestudy.user.repository.UserRepository;



@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	public List<User> listAllUsers() 
	{
		List<User> users = userRepository.findAll();
		
		return users;

}
	
        public User userById(String id)
        {
		
		return userRepository.findById(id).get();
        }
        
        
}
