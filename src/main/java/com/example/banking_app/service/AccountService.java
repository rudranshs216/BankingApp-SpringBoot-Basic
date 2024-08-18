package com.example.banking_app.service;

import com.example.banking_app.dto.AccountDTO;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    AccountDTO deposit(Long id, double amount);
    AccountDTO withdraw(Long id, double amount);

}
