package com.cognizant.productcrud.controller;

import com.cognizant.productcrud.exception.ProductNotFoundException;
import com.cognizant.productcrud.model.Department;
import com.cognizant.productcrud.model.Product;
import com.cognizant.productcrud.service.ProductCrudLogicImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest {

    ProductController productController;
    ProductCrudLogicImpl productService;

    @BeforeEach
    public void setUp() throws Exception {
        productService = Mockito.mock(ProductCrudLogicImpl.class);
        productController = new ProductController(productService);
    }

    @Test
    public void getAll_CallsService(){
        List<Product> expected = Arrays.asList(
                new Product(1L, "Short-Sleeved Shirt", new Department(1L, "Clothes")),
                new Product(2L, "Long-Sleeved Shirt", new Department(1L, "Clothes"))
        );

        Mockito.when(productService.getAll()).thenReturn(expected);

        List<Product> actual = productController.getAllProducts().getBody();

        Mockito.verify(productService).getAll();

        assertEquals(expected, actual);

    }

    @Test
    public void getProductByIdCallsService_ReturnsOk() throws ProductNotFoundException {

        Product expected =  new Product(1L, "Long-Sleeved Shirt", new Department(1L, "Clothes"));
        Mockito.when(productService.getProductById(1L)).thenReturn(expected);

        ResponseEntity<Product> response = productController.getProductById(1L);

        Mockito.verify(productService).getProductById(1L);
        assertEquals(expected, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getProductById_ReturnsProductNotFoundExceptionOn404() throws ProductNotFoundException {

        Mockito.when(productService.getProductById(1L)).thenThrow(new ProductNotFoundException());

        ResponseEntity<Product> response = productController.getProductById(1L);

        assertEquals(null , response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}