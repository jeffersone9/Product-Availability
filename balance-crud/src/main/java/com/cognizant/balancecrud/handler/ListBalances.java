package com.cognizant.balancecrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.balancecrud.controller.BalanceController;
import com.cognizant.balancecrud.model.Request;

public class ListBalances implements RequestHandler<Request, String> {

    private BalanceController balanceController;

    @Override
    public String handleRequest(Request input, Context context){
        return String.valueOf(balanceController.getAllBalances());
    }
}
