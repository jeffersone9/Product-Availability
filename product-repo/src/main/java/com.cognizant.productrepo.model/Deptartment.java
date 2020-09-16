package com.cognizant.productrepo.model;

@Entity
public class Department implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String departmentName;
}