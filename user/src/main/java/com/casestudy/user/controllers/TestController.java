package com.casestudy.user.controllers;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.user.clients.OrderClient;
import com.casestudy.user.clients.ProductClient;
import com.casestudy.user.model.Payment;
import com.casestudy.user.model.Product;
import com.casestudy.user.model.ProductResponse;
import com.casestudy.user.model.User;
import com.casestudy.user.service.UserService;



//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
@EnableFeignClients("com.*")
public class TestController 
{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductClient productClient;
	@Autowired
	private OrderClient orderClient;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	//-------------------------------------
	
	@GetMapping("/userList")
	@PreAuthorize("hasRole('ADMIN')")
	List<User> userList()
	{
		return userService.listAllUsers();
	}
	
	//------------------------------------
	
	@GetMapping("/userListt")
	//@PreAuthorize("hasRole('ADMIN')")
	List<User> userListt()
	{
		return userService.listAllUsers();
	}
	
	//------------------------------------
	
	@GetMapping("/productList")
	@PreAuthorize("hasRole('USER')")
	List<Product> productList()
	{
		return productClient.productList();
	}
	
	@PostMapping("/addProduct")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid Product product)
	{
		return productClient.addProduct(product);
	}
	
	@PutMapping("/productUpdate")
	@PreAuthorize("hasRole('ADMIN')")
    ProductResponse updateProduct(@RequestBody Product product)
    {
		return productClient.updateProduct(product);
    }
	
	@DeleteMapping("/product/{id}")
	@PreAuthorize("hasRole('ADMIN')")
    ProductResponse deleteProductById(@PathVariable String id)
    {
		return productClient.deleteProductById(id);
    }
	//--------------------------------------------------------------------
	
	@GetMapping("/orderList")
	@PreAuthorize("hasRole('ADMIN')")
	List<Payment> orderList()
	{
		return orderClient.pList();
	}
	
}
