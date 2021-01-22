package com.cognizant.balancecrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDB implements Serializable {

    @Id
    private Long id;
    private int balance;
    private Long productId;
    private Long locationId;
}
