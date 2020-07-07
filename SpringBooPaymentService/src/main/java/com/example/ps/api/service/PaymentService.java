package com.example.ps.api.service;

import com.example.ps.api.domain.PaymentDomain;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentService {
	
	public PaymentDomain dopayment(PaymentDomain paymentDomain) throws JsonProcessingException;
	public PaymentDomain findPaymentByOrderId(int orderId);
}
