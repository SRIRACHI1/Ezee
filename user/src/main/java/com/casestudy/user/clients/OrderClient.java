package com.casestudy.user.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.casestudy.user.model.Payment;



@FeignClient(url = "http://localhost:9095/payment",name = "order-client")
public interface OrderClient
{
	@GetMapping("/pList")
	List<Payment> pList();

}
