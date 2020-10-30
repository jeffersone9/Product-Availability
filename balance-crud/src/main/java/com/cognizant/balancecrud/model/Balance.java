package com.cognizant.balancecrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Balance {

    @Id
    private Long id;
    private int balance;
//    private Product product;
//    private Location location;

}
