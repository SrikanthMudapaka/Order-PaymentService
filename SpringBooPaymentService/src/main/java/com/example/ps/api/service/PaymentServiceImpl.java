package com.example.ps.api.service;


import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ps.api.domain.PaymentDomain;
import com.example.ps.api.entity.Payment;
import com.example.ps.api.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentServiceImpl {

	@Autowired
	private PaymentRepository paymentRepository;
	private Logger log=LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	public PaymentDomain dopayment(PaymentDomain paymentDomain) throws JsonProcessingException {
		Payment payment= new Payment();
		BeanUtils.copyProperties(paymentDomain, payment);
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		log.info("Payment-Service request:",new ObjectMapper().writeValueAsString(payment));
		 Payment save = paymentRepository.save(payment);
		 if(save.getPaymentId()!=null) {
			 paymentDomain= new PaymentDomain(save.getPaymentId(),save.getPaymentStatus(),save.getTransactionId(),save.getOrderId(),save.getAmount());
			
		 }
		return paymentDomain;
	}
	 
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"fail";
	}

	public PaymentDomain findPaymentByOrderId(int orderId) throws JsonProcessingException {
		// TODO Auto-generated method stub
		PaymentDomain response = new PaymentDomain();
		Payment findByOrderId = paymentRepository.findByOrderId(orderId);
		//logging
		log.info("Payment-Service request:",new ObjectMapper().writeValueAsString(findByOrderId));
		BeanUtils.copyProperties(findByOrderId, response);
		return response;
	}
}
