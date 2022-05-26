package com.ameda.kevin.kisevu.controller;

import com.ameda.kevin.kisevu.Entity.Transactions;
import com.ameda.kevin.kisevu.model.TransactionModel;
import com.ameda.kevin.kisevu.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create-a-transaction")
    public Transactions createTransaction(@RequestBody TransactionModel transactionModel){
        Transactions transaction=transactionService.createTransaction(transactionModel);
        return transaction;
    }
}
