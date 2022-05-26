package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Account;
import com.ameda.kevin.kisevu.model.AccountModel;

public interface AccountService {
    Account createAccount(AccountModel accountModel);

    Account addFunds(Long accountId,AccountModel accountModel);

    Account removeFunds(Long accountId, AccountModel accountModel);

    Account transferFunds(AccountModel accountModel, Double withdrawn,Long accountId);
}
