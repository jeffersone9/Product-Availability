package com.cognizant.productcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.productcrud.repository.ProductRepo;
import com.google.gson.Gson;

import java.util.Map;

public class ListProducts implements RequestHandler<Map<String, String>, String> {

    private ProductRepo productRepo;
    private Gson gson = new Gson();

    @Override
    public String handleRequest(Map<String, String> event, Context context){
        return gson.toJson(productRepo.findAll());
    }
}
