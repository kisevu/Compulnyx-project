package com.ameda.kevin.kisevu.model;

import com.ameda.kevin.kisevu.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountModel {
    private Long accountNumber;
    private Double balance;
    private Double deposit;
    private Double withdrawn;
    private Customer customer;
}
