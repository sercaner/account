package com.sercaner.account.repository;

import com.sercaner.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String>{
}
