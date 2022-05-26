package com.ameda.kevin.kisevu.repository;

import com.ameda.kevin.kisevu.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long> {
}
