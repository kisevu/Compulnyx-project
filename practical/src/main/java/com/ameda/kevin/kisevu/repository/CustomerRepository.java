package com.ameda.kevin.kisevu.repository;

import com.ameda.kevin.kisevu.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
    public Customer findByEmailId(String emailId);
}
