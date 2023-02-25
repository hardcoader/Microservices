package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableHystrixDashboard
public class HextrixDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HextrixDashBoardApplication.class, args);
	}

}
