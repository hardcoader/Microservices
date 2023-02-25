package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("orderFall")
	public Mono<String> orderServicefallback() {
		return Mono.just("oder donw tey latetr");
	}

	@RequestMapping("paymentFall")
	public Mono<String> paymentServicefallback() {
		return Mono.just("payment donw tey latetr");
	}

}
