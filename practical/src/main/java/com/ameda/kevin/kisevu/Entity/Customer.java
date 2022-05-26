package com.ameda.kevin.kisevu.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence",sequenceName ="customer_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_sequence")
    private Long customerId;
    private String customerName;
    @Column(name ="email_address",nullable = false,unique = true)
    private String emailId;
    private String password;
    @OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "account_id",referencedColumnName = "accountId")
    private Account account;
}
