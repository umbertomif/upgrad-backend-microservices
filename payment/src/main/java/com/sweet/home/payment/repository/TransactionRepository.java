package com.sweet.home.payment.repository;

import com.sweet.home.payment.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Integer> {
}
