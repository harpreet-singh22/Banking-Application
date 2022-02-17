package com.example.demo.services.impl;

import com.example.demo.models.Accounts;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.services.AccountService;
import com.example.demo.services.TransactionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  AccountService accountService;

  @Override
  public Object saveTransaction(Transaction transaction, String transactionType, Long accountNumber) throws Exception {
    if(StringUtils.hasText(transactionType)){
      if(transactionType.equalsIgnoreCase("DEBIT")){
        transaction.setType(transactionType);
        Optional<Accounts> optional = accountRepository.findById(accountNumber);
        if(optional.isPresent()){
          Accounts account = optional.get();
          if(account.getBalance() >= transaction.getAmount()){
            transaction.setAccount(account);
          }
          else {
            return new ResponseEntity(new Exception("Insufficient balance"), HttpStatus.BAD_REQUEST);
          }
        }
        else {
          return new ResponseEntity(new Exception("Account Not Found"), HttpStatus.NOT_FOUND);
        }
        transactionRepository.save(transaction);
      }
      else if(transactionType.equalsIgnoreCase("CREDIT")){
        transaction.setType(transactionType);
        Optional<Accounts> optional = accountRepository.findById(accountNumber);
        if(optional.isPresent()){
          transaction.setAccount(optional.get());
        }
        else {
          return new ResponseEntity(new Exception("Account Not Found"), HttpStatus.NOT_FOUND);
        }
        transactionRepository.save(transaction);
      }
      else {
        return new ResponseEntity(new Exception("Invalid type of transaction"), HttpStatus.BAD_REQUEST);
      }

      //update balance
      return accountService.updateAccountBalance(accountNumber, transaction.getAmount(), transactionType);
    }

    return null;
  }
}
