package com.cognizant.productcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.productcrud.controller.ProductController;

public class ListProducts implements RequestHandler<String, String> {

    private ProductController productController;

    @Override
    public String handleRequest(String input, Context context){
        return String.valueOf(productController.getAllProducts());
    }
}
