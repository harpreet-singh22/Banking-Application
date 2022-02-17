package com.example.demo.services;

import com.example.demo.models.Transaction;

public interface TransactionService {

  //Save transaction
  Object saveTransaction(Transaction transaction, String transactionType, Long accountNumber) throws Exception;
}
