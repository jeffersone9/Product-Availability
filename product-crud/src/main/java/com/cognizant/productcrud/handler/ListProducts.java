package com.cognizant.productcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.productcrud.controller.ProductController;
import com.cognizant.productcrud.model.Request;

public class ListProducts implements RequestHandler<Request, String> {

    private ProductController productController;

    @Override
    public String handleRequest(Request input, Context context){
        return String.valueOf(productController.getAllProducts());
    }
}
