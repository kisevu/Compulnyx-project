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
public class TransactionModel {
    private Long transactions_serial;
    private String date;
    private String time;
    private Customer customer;
}
