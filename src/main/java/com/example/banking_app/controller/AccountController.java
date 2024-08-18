package com.example.banking_app.controller;

import com.example.banking_app.dto.AccountDTO;
import com.example.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    Add Account Rest API
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

//    Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        AccountDTO accountDTO = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

//    Deposit into Account REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDTO);
    }

    //    Withdraw from Account REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDTO);
    }
}
