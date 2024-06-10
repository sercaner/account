package com.sercaner.account.service;

import com.sercaner.account.model.Account;
import com.sercaner.account.model.Transaction;
import com.sercaner.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, final BigDecimal amount) {
        return transactionRepository.save(
                new Transaction(amount, account)
        );
    }
}
