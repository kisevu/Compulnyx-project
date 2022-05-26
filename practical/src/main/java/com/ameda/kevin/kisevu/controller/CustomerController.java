package com.ameda.kevin.kisevu.controller;

import com.ameda.kevin.kisevu.Entity.Account;
import com.ameda.kevin.kisevu.Entity.Customer;
import com.ameda.kevin.kisevu.model.CustomerModel;
import com.ameda.kevin.kisevu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register-customer")
    public Customer registerCustomer(@RequestBody CustomerModel customerModel){
        Customer customer=customerService.registerCustomer(customerModel);
        System.out.println("Customer successfully registered.");
        return customer;
    }
    @GetMapping("/all-customers")
    public List<Customer> retrieveAllCustomers(){
        List<Customer> customers=customerService.retrieveAllCustomers();
        return customers;
    }
    @GetMapping("/getYourBalance")
    public Double getCustomerBalance(@RequestParam("emailId") String emailId,
                                   @RequestParam("customerId") Long customerId){
        Customer customer=customerService.getCustomerBalance(emailId,customerId);
        return customer.getAccount().getBalance();
    }
    @GetMapping("/mini-statement/{customerId}")
    public Account getCustomerMiniStatement(@PathVariable("customerId") Long customerId){
        Customer customer=customerService.getCustomerMiniStatement(customerId);
        Account account=customer.getAccount();
        return account;
    }
}
