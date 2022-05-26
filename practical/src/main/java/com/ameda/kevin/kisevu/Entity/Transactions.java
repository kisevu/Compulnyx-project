package com.ameda.kevin.kisevu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Transactions{
    @Id
    @SequenceGenerator(name = "transactions_sequence",sequenceName = "transactions_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="transactions_sequence")
    private Long transactionId;
    private Long transactions_serial;
    private String date;
    private String time;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;
}
