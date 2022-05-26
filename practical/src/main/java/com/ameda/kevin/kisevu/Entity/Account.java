package com.ameda.kevin.kisevu.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account{
    @Id
    @SequenceGenerator(name = "account_sequence",sequenceName ="account_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="account_sequence")
    private Long accountId;
    private Long accountNumber;
    private Double balance;
    private Double deposit;
    private Double withdrawn;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "account")
    @JsonIgnore
    private Customer customer;
}
