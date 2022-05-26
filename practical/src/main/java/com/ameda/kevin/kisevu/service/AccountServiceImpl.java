package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Account;
import com.ameda.kevin.kisevu.Entity.Customer;
import com.ameda.kevin.kisevu.model.AccountModel;
import com.ameda.kevin.kisevu.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account createAccount(AccountModel accountModel) {
        Customer customer=Customer.builder()
                .customerName(accountModel.getCustomer().getCustomerName())
                .emailId(accountModel.getCustomer().getEmailId())
                .password(accountModel.getCustomer().getPassword())
                .account(accountModel.getCustomer().getAccount())
                .build();
      Account account=Account
              .builder()
              .accountNumber(accountModel.getAccountNumber())
              .balance(accountModel.getBalance())
              .deposit(accountModel.getDeposit())
              .withdrawn(accountModel.getWithdrawn())
              .customer(customer)
                      .build();
      accountRepository.save(account);
      return  account;
    }

    @Override
    public Account addFunds(Long accountId,AccountModel accountModel) {
        Account account=accountRepository.findByAccountId(accountId);
        account.setDeposit(accountModel.getDeposit());
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account removeFunds(Long accountId, AccountModel accountModel) {
        Account account=accountRepository.findByAccountId(accountId);
        account.setWithdrawn(accountModel.getWithdrawn());
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account transferFunds(AccountModel accountModel, Double withdrawn,Long accountId) {
        Account account=accountRepository.findByAccountId(accountId);
        account.setWithdrawn(withdrawn);
        accountRepository.save(account);
        return account;
    }
}
