package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serviceImpl.CustomerServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public CustomerServiceImpl getCustomerServiceImplBean(){
		return new CustomerServiceImpl();
	}
}
