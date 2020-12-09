package com.cognizant.productcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.productcrud.controller.ProductController;

import java.util.Map;

public class ListProducts implements RequestHandler<Map<String, String>, String> {

    private ProductController productController;

    @Override
    public String handleRequest(Map<String, String> event, Context context){
        return String.valueOf(productController.getAllProducts());
    }
}
