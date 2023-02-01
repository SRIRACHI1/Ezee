package com.casestudy.user.clients;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casestudy.user.model.Product;
import com.casestudy.user.model.ProductResponse;



@FeignClient(url = "http://localhost:9091/v1",name = "product-client")
public interface ProductClient
{
	@PostMapping("/addProduct")
	ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid Product product);
	
	@GetMapping("/productList")
	List<Product> productList();
	
	@PutMapping("/productUpdate")
    ProductResponse updateProduct(@RequestBody Product product);
	
	@DeleteMapping("/product/{id}")
    ProductResponse deleteProductById(@PathVariable String id);

}
