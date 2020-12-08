package com.cognizant.locationcrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.locationcrud.controller.LocationController;
import com.cognizant.locationcrud.model.Request;

public class ListLocations implements RequestHandler<Request, String> {

    private LocationController locationController;

    @Override
    public String handleRequest(Request input, Context context) {
        return String.valueOf(locationController.getAllLocations());
    }
}
