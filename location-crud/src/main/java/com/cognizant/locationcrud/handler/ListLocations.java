package com.cognizant.locationcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.locationcrud.controller.LocationController;

public class ListLocations implements RequestHandler{

    private LocationController locationController;

    @Override
    public String handleRequest(Object input, Context context) {
        return String.valueOf(locationController.getAllLocations());
    }
}
