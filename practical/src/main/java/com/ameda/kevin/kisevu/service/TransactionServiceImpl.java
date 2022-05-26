package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Account;
import com.ameda.kevin.kisevu.Entity.Customer;
import com.ameda.kevin.kisevu.Entity.Transactions;
import com.ameda.kevin.kisevu.model.TransactionModel;
import com.ameda.kevin.kisevu.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Transactions createTransaction(TransactionModel transactionModel) {
        Customer customer=Customer.builder()
                .customerName(transactionModel.getCustomer().getCustomerName())
                .emailId(transactionModel.getCustomer().getEmailId())
                .password(transactionModel.getCustomer().getPassword())
                .account(transactionModel.getCustomer().getAccount())
                .build();
        Transactions transaction=Transactions.builder()
                .transactions_serial(transactionModel.getTransactions_serial())
                .date(transactionModel.getDate())
                .time(transactionModel.getTime())
                .customer(customer)
                .build();
        transactionRepository.save(transaction);
        return transaction;
    }
}
