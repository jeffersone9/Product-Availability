package com.cognizant.balancecrud.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cognizant.balancecrud.controller.BalanceController;
import com.cognizant.balancecrud.repository.BalanceRepo;
import com.google.gson.Gson;

public class ListBalances implements RequestHandler <String, String>{

    private BalanceRepo balanceRepo;
    private Gson gson = new Gson();

    @Override
    public String handleRequest(String input, Context context){
        return gson.toJson(balanceRepo.findAll());
    }
}
