package com.cognizant.locationcrud.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.cognizant.locationcrud.LocationCrudApplication;
import com.cognizant.locationcrud.controller.LocationController;
import com.cognizant.locationcrud.repository.LocationRepo;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ListLocations implements RequestStreamHandler {

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static{
        try{
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(LocationCrudApplication.class);
        } catch(ContainerInitializationException e){
            e.printStackTrace();
            throw new RuntimeException("Could not init location App", e);
        }
    }

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        handler.proxyStream(input, output, context);
    }
}
