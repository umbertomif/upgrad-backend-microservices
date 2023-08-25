package com.sweet.home.payment;

import com.sweet.home.payment.entities.TransactionDetailsEntity;
import com.sweet.home.payment.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sweet.home.payment.repository")
public class PaymentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PaymentApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
