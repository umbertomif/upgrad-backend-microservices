package com.sweet.home.booking.feign;

import com.sweet.home.booking.dto.TransactionDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "API-GATEWAY")
public interface PaymentServiceClient {

    // TODO: need to change the value to use config server
    @PostMapping(value = "${paymentApp.transactionPath}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int transaction(TransactionDetailsDTO data);

    // TODO: need to change the value to use config server
    @GetMapping(value = "${paymentApp.bookingTransactionIdPath}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TransactionDetailsDTO getTransactionById(@PathVariable(name = "transactionId") int transactionId);
}
