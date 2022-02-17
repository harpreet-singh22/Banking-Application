package com.example.demo.controllers;

import com.example.demo.models.Accounts;
import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  // Save operation
  @PostMapping("/transaction/{type}")
  public Object createTransaction(
      @RequestParam(value = "accountNumber") Long accountNumber,
      @PathVariable(value = "type") String transactionType,
      @RequestBody Transaction transaction) throws Exception {
    return transactionService.saveTransaction(transaction, transactionType, accountNumber);
  }
}
