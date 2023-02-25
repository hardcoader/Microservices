package com.example.demo;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(pyamentProcessing());
		payment.setTraId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	
	public String pyamentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}


	public Payment findpaymentByOrderId(int id) {
		
		return paymentRepository.findById(id).get();
	}
}
