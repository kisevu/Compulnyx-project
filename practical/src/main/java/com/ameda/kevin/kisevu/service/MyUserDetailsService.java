package com.ameda.kevin.kisevu.service;

import com.ameda.kevin.kisevu.Entity.Customer;
import com.ameda.kevin.kisevu.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public MyUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }
    @Override
    public CustomUserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Customer customer=customerRepository.findByEmailId(emailId);
        if(customer==null){
            throw new UsernameNotFoundException("Customer with ["+emailId+"] not found.");
        }
        return new CustomUserDetails(customer);
    }
}
