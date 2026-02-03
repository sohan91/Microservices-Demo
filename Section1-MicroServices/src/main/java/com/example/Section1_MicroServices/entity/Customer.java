package com.example.Section1_MicroServices.entity;


import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column(name="name")
    private String customerName;

    @Column(name="email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;


}
