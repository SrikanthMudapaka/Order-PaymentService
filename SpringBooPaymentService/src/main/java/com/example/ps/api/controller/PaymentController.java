package com.example.ps.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ps.api.domain.PaymentDomain;
import com.example.ps.api.entity.Payment;
import com.example.ps.api.service.PaymentService;
import com.example.ps.api.service.PaymentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@PostMapping("/dopayment")
	public PaymentDomain doSavePaymnet(@RequestBody PaymentDomain payment) throws JsonProcessingException {
		return paymentServiceImpl.dopayment(payment);
		
	}
	
	@GetMapping(value = "/hi/{orderid}")
	public String getMesssage(@PathVariable Integer orderid){
		return "Hello"+orderid;
	}
	
	@GetMapping(value = "/{orderId}")
	public PaymentDomain findPaymentHistoryByOrderId(@PathVariable Integer orderId) throws JsonProcessingException {
	
	return paymentServiceImpl.findPaymentByOrderId(orderId);	
	}
	
	
	
	
	
	
	
	
	
	

}
 