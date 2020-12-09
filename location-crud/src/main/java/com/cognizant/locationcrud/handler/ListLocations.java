package com.cognizant.locationcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.locationcrud.controller.LocationController;
import com.cognizant.locationcrud.repository.LocationRepo;
import com.google.gson.Gson;

public class ListLocations implements RequestHandler <String, String>{

    private LocationRepo locationRepo;
    private Gson gson = new Gson();

    @Override
    public String handleRequest(String input, Context context) {
        return gson.toJson(locationRepo.findAll());
    }
}
