package com.cognizant.balancecrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Balance {

    @Id
    private Long id;
    private int balance;
    private Long productId;
    private Long locationId;
}
