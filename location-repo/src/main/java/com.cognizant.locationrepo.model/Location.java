package com.cognizant.locationrepo.model;

@Entity
public class Location implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String zipcode;
}