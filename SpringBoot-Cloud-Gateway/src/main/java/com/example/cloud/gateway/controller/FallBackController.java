package com.example.cloud.gateway.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping(value = "/orderfallback")
	public Mono<String> orderServiceFallBack(){
		return Mono.just("Order service is taking too long to respond r is slow. please try again after some time");
	}
	
	@RequestMapping(value = "/paymentfallback")
	public Mono<String> paymentServiceFallBack(){
		return Mono.just("Payment service is taking too long to respond r is slow. please try again after some time");
	}
}
