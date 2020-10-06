package com.cognizant.productcrud.service;

import com.cognizant.productcrud.exception.ProductNotFoundException;
import com.cognizant.productcrud.model.Product;
import com.cognizant.productcrud.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCrudLogicImpl implements ProductCrudLogic {

    private ProductRepo productRepo;

    public ProductCrudLogicImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product> optional = productRepo.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new ProductNotFoundException();
    }
}
