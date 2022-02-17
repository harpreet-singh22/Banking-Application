package com.example.demo.services.impl;

import com.example.demo.models.Accounts;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.services.AccountService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository accountRepository;

  @Override
  public String createAccount(Accounts account) {
    accountRepository.save(account);
    return "Account created successfully with account number : " + account.getAccountNumber();
  }

  @Override
  public void deleteAccountByAccountNumber(Long accountNumber) {
    accountRepository.deleteById(accountNumber);
  }

  @Override
  public String updateAccountBalance(Long accountNumber, Double currentTransactionAmount, String transactionType){
    Optional<Accounts> accountsOptional = accountRepository.findById(accountNumber);
    Accounts updatedAccount;
    if(accountsOptional.isPresent()){
      updatedAccount = accountsOptional.get();
      updatedAccount.setBalance((transactionType.equalsIgnoreCase("DEBIT") ?
          updatedAccount.getBalance() - currentTransactionAmount : updatedAccount.getBalance() + currentTransactionAmount));
      accountRepository.save(updatedAccount);
      return "Balance updated successfully; New Balance : " + updatedAccount.getBalance();
    }

    return null;
  }
}
