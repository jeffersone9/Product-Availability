package com.cognizant.balancecrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.balancecrud.controller.BalanceController;

public class ListBalances implements RequestHandler<Object, String> {

    private BalanceController balanceController;

    @Override
    public String handleRequest(Object input, Context context){
        return String.valueOf(balanceController.getAllBalances());
    }
}
