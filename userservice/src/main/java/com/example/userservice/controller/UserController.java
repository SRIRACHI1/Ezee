package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.UserModel;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.securityconfig.AuthenticationRequest;
import com.example.userservice.securityconfig.AuthenticationResponse;
import com.example.userservice.service.MyUserService;
import com.example.userservice.service.UserService;
import com.example.userservice.util.JwtUtils;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController{
	
@Autowired
JwtUtils jwtutil;

@Autowired
MyUserService userservice;

@Autowired
UserRepository userrepo;

@Autowired
AuthenticationManager authenticates;

@Autowired
UserService uservice;

@PostMapping("/subs")
private ResponseEntity<AuthenticationResponse>subscribeClient(@RequestBody AuthenticationRequest authreq)
{
	UserModel usermodel =new UserModel();
	usermodel.setEmail(authreq.getEmail());
	usermodel.setPassword(authreq.getPassword());
	usermodel.setUsername(authreq.getUsername());
	usermodel.setPhone(authreq.getPhone());
	usermodel.setInsertDate(authreq.getInsertDate());
	usermodel.setExpireDate(authreq.getExpireDate());
	try {
			userrepo.save(usermodel);
		}
	catch(Exception e){
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
				("Error during subscription ") , HttpStatus.OK);
	}

 return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
("Successful subs for client " +authreq.getUsername()), HttpStatus.OK);
}

@PostMapping("/authenticate")
private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authreq){

	
	String username=authreq.getUsername();
	String password= authreq.getPassword();
	
try {
authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));

 }
catch(Exception e) {
return ResponseEntity.ok(new AuthenticationResponse(" Invalid Credentials..! Try Again .."));
}

 UserDetails userdetails= uservice.loadUserByUsername(username);

 String jwt = jwtutil.generateToken(userdetails);

 return ResponseEntity.ok(new AuthenticationResponse(jwt));
}

@GetMapping("/test")
private String testingtoken() {
try {
return "Testing Successful...!";
}
catch(Exception e) {
return "Please login first..!";
}
}

@GetMapping("/dashboard")
private String dashboard() {
return "Welcome to dashboard...!";
}
@RequestMapping("/user")
public List<UserModel>getAllUsers()

{
return userservice.getAllUsers();
}



/*
 * @RequestMapping(method=RequestMethod.POST, value="/user") public void
 * add(@RequestBody UserModel us) { userservice.add(us); }
 */


@RequestMapping(method=RequestMethod.PUT, value="/user/{Id}")
public void UpdateUser(@RequestBody UserModel us,@PathVariable String Id)
{
userservice.Update(Id,us);
}


@RequestMapping(method=RequestMethod.DELETE, value="/user/{Id}")
public void deleteUser(@RequestBody UserModel us)
{
userservice.delete(us);
}
}
