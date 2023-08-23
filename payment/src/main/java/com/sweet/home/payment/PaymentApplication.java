package com.sweet.home.payment;

import com.sweet.home.payment.entities.TransactionDetailsEntity;
import com.sweet.home.payment.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PaymentApplication.class, args);

		// Testing
		TransactionService transactionService = context.getBean(TransactionService.class);
		System.out.println("Transaction Service bean : " + transactionService);

		System.out.println("created");
		TransactionDetailsEntity createTransaction = new TransactionDetailsEntity();
		createTransaction.setPaymentMode("card");
		createTransaction.setBookingId(1);
		createTransaction.setCardNumber("1234567890");
		TransactionDetailsEntity created = transactionService.createTransaction(createTransaction);
		System.out.println(created);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
