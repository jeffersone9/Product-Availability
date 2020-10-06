package com.cognizant.productcrud.service;

import com.cognizant.productcrud.exception.ProductNotFoundException;
import com.cognizant.productcrud.model.Department;
import com.cognizant.productcrud.model.Product;
import com.cognizant.productcrud.repository.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductCrudLogicImplTest {

    ProductRepo productRepo;
    ProductCrudLogicImpl productService;

    @BeforeEach
    public void setUp() throws Exception {
        productRepo = Mockito.mock(ProductRepo.class);
        productService = new ProductCrudLogicImpl(productRepo);
    }

    /**
     * Just need to get products
     * (will use sql statements input dummy data into db)
     */
    @Test
    public void getAll_CallsRepoFindAll(){
        List<Product> expected = Arrays.asList(
                new Product(1L, "Short-Sleeved Shirt", new Department(1L, "Clothes")),
                new Product(2L, "Long-Sleeved Shirt", new Department(1L, "Clothes"))
        );

        when(productRepo.findAll()).thenReturn(expected);

        productService.getAll();

        verify(productRepo).findAll();
    }

    @Test
    public void getProductByIdReturnsProduct() throws ProductNotFoundException {
        Product expected = new Product(1L, "Short-Sleeved Shirt", new Department(1L, "Clothes"));
        when(productRepo.findById(1L)).thenReturn(Optional.of(expected));

        Product actual = productService.getProductById(1L);

        assertEquals(expected, actual);
        verify(productRepo).findById(1L);
    }

    @Test
    public void getProductById_ThrowsProductNotFoundExceptionWhenNoProduct(){
        Assertions.assertThrows(ProductNotFoundException.class, () ->{
            productService.getProductById(122L);
        });
    }
}