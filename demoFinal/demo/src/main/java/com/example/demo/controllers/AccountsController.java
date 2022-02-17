package com.example.demo.controllers;

import com.example.demo.models.Accounts;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

  @Autowired
  AccountService accountService;

  // Save operation
  @PostMapping("/account/create")
  public String createAccounts(
      @RequestBody Accounts account) {
    return accountService.createAccount(account);
  }

  // Delete operation
  @DeleteMapping("/account/{accountNumber}")
  public String deleteAccounts(@PathVariable("accountNumber")
                                   Long accountNumber)
  {
    accountService.deleteAccountByAccountNumber(accountNumber);
    return "Deleted Successfully";
  }

}
