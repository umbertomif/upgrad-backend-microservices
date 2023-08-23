package com.sweet.home.payment.controllers;

import com.sweet.home.payment.dto.TransactionDetailsDTO;
import com.sweet.home.payment.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment_app")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(
            value ="/healthy-check"
    )
    public Object checkStatus() {
        return ResponseEntity.ok().body("Service is up and running fine.");
    }

    // RequestBody: paymentMode, bookingId, upiId, cardNumber
    @PostMapping(
            value = "/transaction",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> transaction(TransactionDetailsDTO data) {
        return new ResponseEntity(1, HttpStatus.CREATED);
    }

    @GetMapping(
            value ="/transaction/{transactionId}"
    )
    public ResponseEntity<TransactionDetailsDTO> getTransactionById(@PathVariable(name = "transactionId") int transactionId) {
        return new ResponseEntity(new TransactionDetailsDTO(), HttpStatus.CREATED);
    }
}
