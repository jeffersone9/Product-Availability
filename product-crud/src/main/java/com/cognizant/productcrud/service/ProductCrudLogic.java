package com.cognizant.productcrud.service;

import com.cognizant.productcrud.exception.ProductNotFoundException;
import com.cognizant.productcrud.model.Product;

import java.util.List;

public interface ProductCrudLogic {
    public List<Product> getAll();

    public Product getProductById(long l) throws ProductNotFoundException;
}
