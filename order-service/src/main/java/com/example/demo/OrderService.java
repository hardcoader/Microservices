package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@RefreshScope
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	@Lazy
	RestTemplate restTemplate;
	
	Logger log= LoggerFactory.getLogger(OrderService.class);

	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String paymenturl;

	public Tranacrionresposne saveOrder(TransactionRequest order) throws JsonProcessingException {
		log.info("order service{}", new ObjectMapper().writeValueAsString(order));
		Payment payment = order.getPayment();
		payment.setOrderid(order.getOrder().getId());
		payment.setPrice(order.getOrder().getPrice());

		ResponseEntity<Payment> res = restTemplate.postForEntity(paymenturl, payment, Payment.class);
		log.info("payment service{}", new ObjectMapper().writeValueAsString(res));
		orderRepository.save(order.getOrder());
		Tranacrionresposne s = new Tranacrionresposne();
		s.setAmount(res.getBody().paymentId);
		return s;
	}

}
