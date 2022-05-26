package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Account;
import com.ameda.kevin.kisevu.Entity.Customer;
import com.ameda.kevin.kisevu.model.AccountModel;
import com.ameda.kevin.kisevu.model.CustomerModel;
import com.ameda.kevin.kisevu.repository.AccountRepository;
import com.ameda.kevin.kisevu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Customer> retrieveAllCustomers() {
        List<Customer> customers=customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer getCustomerBalance(String emailId,Long customerId) {
        Customer customer=customerRepository.findByEmailId(emailId);
        if(customer.getCustomerId()==customerId){
            return customer;
        }
        return null;
    }

    @Override
    public Customer getCustomerMiniStatement(Long customerId) {
        Customer customer=customerRepository.findById(customerId).get();
        if(customer.getCustomerId()==customerId){
            System.out.println("Customer with the id found..");
            return customer;
        }
        System.out.println("Customer with that id not found...");
        return null;
    }

    @Override
    public Customer registerCustomer(CustomerModel customerModel) {
        Account account=Account.builder()
                .accountNumber(customerModel.getAccount().getAccountNumber())
                .balance(customerModel.getAccount().getBalance())
                .deposit(customerModel.getAccount().getDeposit())
                .withdrawn(customerModel.getAccount().getWithdrawn())
                .build();
        Customer customer=Customer.builder()
                .customerName(customerModel.getCustomerName())
                .emailId(customerModel.getEmailId())
                .password(customerModel.getPassword())
                .account(account)
                .build();
        customerRepository.save(customer);
        return customer;
    }
}
