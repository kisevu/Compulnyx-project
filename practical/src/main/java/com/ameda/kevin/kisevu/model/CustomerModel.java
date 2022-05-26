package com.ameda.kevin.kisevu.model;

import com.ameda.kevin.kisevu.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerModel {
    private String customerName;
    private String emailId;
    private String password;
    private Account account;
}
