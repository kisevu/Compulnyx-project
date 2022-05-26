package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Transactions;
import com.ameda.kevin.kisevu.model.TransactionModel;

public interface TransactionService {
    Transactions createTransaction(TransactionModel transactionModel);
}
