package com.cognizant.productrepo.model;

@Entity
public class Product implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String productName;

    @Column
    private Department department;


}