package com.sweet.home.payment.services;

import com.sweet.home.payment.entities.TransactionDetailsEntity;

public interface PaymentService {

    public TransactionDetailsEntity createTransaction(TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity geTransactionDetails(int id);

}
