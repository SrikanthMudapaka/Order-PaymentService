package com.example.ps.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ps.api.domain.PaymentDomain;
import com.example.ps.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
