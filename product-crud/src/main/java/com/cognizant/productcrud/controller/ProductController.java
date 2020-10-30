package com.cognizant.productcrud.controller;

import com.cognizant.productcrud.exception.ProductNotFoundException;
import com.cognizant.productcrud.model.Product;
import com.cognizant.productcrud.service.ProductCrudLogic;
import com.cognizant.productcrud.service.ProductCrudLogicImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {

    private final ProductCrudLogic productService;

    public ProductController(ProductCrudLogic productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return  new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        try{
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        }catch(ProductNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
