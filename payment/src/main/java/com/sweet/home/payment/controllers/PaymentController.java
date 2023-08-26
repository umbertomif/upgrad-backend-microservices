package com.sweet.home.payment.controllers;

import com.sweet.home.payment.dto.TransactionDetailsDTO;
import com.sweet.home.payment.entities.TransactionDetailsEntity;
import com.sweet.home.payment.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(
            value = "/healthy-check"
    )
    public ResponseEntity getStatus() {
        return new ResponseEntity("Service is up and running fine.", HttpStatus.OK);
    }

    @PostMapping(
            value = "/transaction",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> transaction(@RequestBody TransactionDetailsDTO data) {
        TransactionDetailsEntity requestedTransaction = modelMapper.map(data, TransactionDetailsEntity.class);
        TransactionDetailsEntity responseTransaction = paymentService.createTransaction(requestedTransaction);
        return new ResponseEntity(responseTransaction.getTransactionId(), HttpStatus.CREATED);
    }

    @GetMapping(
            value ="/transaction/{transactionId}"
    )
    public ResponseEntity<TransactionDetailsEntity> getTransactionById(@PathVariable(name = "transactionId") int transactionId) {
        TransactionDetailsEntity responseTransaction = paymentService.geTransactionDetails(transactionId);
        return new ResponseEntity(responseTransaction, HttpStatus.OK);
    }
}
