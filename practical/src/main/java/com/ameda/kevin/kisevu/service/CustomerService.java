package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Customer;
import com.ameda.kevin.kisevu.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    List<Customer> retrieveAllCustomers();

    Customer getCustomerBalance(String emailId,Long customerId);

    Customer getCustomerMiniStatement(Long customerId);

    Customer registerCustomer(CustomerModel customerModel);
}
