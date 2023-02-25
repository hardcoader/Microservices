package com.example.demo;

import java.util.Random;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/dopayment")
	public Payment doPayment( Payment payment) {
	
		return paymentService.doPayment(payment);
	}
	
	
	@GetMapping("/orderhistory/{id}")
	public Payment findpaymentByOrderId(@PathVariable int id) {
		return paymentService.findpaymentByOrderId(id);
	}
}
