package com.ameda.kevin.kisevu.repository;

import com.ameda.kevin.kisevu.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    public Account findByAccountId(Long accountId);
}
