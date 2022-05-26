package com.ameda.kevin.kisevu.controller;

import com.ameda.kevin.kisevu.Entity.Account;
import com.ameda.kevin.kisevu.model.AccountModel;
import com.ameda.kevin.kisevu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register-account")
    public Account createAccount(@RequestBody AccountModel accountModel){
        Account account=accountService.createAccount(accountModel);
        return account;
    }
   @PatchMapping("/bank/{accountId}")
    public Account addFunds(@RequestBody AccountModel accountModel,
                            @PathVariable("accountId") Long accountId){
        Account account= accountService.addFunds(accountId,accountModel);
        return  account;
    }
    @PatchMapping("/withdraw/{accountId}")
    public Account removeFunds(@RequestBody AccountModel accountModel,
                               @PathVariable("accountId") Long accountId){
        Account account=accountService.removeFunds(accountId,accountModel);
        return account;
    }
    @PatchMapping("/funds-transfer/{accountId}/{withdrawn}")
    public Account transferFunds(@RequestBody AccountModel accountModel,
                                 @PathVariable("withdrawn") Double withdrawn,
                                 @PathVariable("accountId") Long accountId){
        Account account=accountService.transferFunds(accountModel,withdrawn,accountId);
        return account;
    }
}
