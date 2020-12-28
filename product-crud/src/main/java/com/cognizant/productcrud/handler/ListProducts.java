package com.cognizant.productcrud.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.cognizant.productcrud.ProductCrudApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ListProducts implements RequestStreamHandler {

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static{
        try{
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(ProductCrudApplication.class);
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
