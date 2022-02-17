package com.example.demo.services;

import com.example.demo.models.Accounts;

public interface AccountService {

  // Save operation
  String createAccount(Accounts account);

  // Delete operation
  void deleteAccountByAccountNumber(Long accountNumber);

  //Update Balance
  String updateAccountBalance(Long accountNumber, Double currentTransactionAmount, String transactionType);

}
