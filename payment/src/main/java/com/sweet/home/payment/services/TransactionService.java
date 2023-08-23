package com.sweet.home.payment.services;

import com.sweet.home.payment.entities.TransactionDetailsEntity;

public interface TransactionService {

    public TransactionDetailsEntity createTransaction(TransactionDetailsEntity transactionDetailsEntity);
}
