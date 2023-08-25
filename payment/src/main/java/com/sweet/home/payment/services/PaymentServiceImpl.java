package com.sweet.home.payment.services;

import com.sweet.home.payment.repository.TransactionRepository;
import com.sweet.home.payment.entities.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public TransactionDetailsEntity createTransaction(TransactionDetailsEntity transactionDetailsEntity) {
        return repository.save(transactionDetailsEntity);
    }

    @Override
    public TransactionDetailsEntity geTransactionDetails(int id) {
        return repository.findById(id).get();
    }
}
