package com.cognizant.balancecrud.service;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.Balance;

import java.util.List;

public interface BalanceCrudLogic {
    List<Balance> findAll();

    Balance getBalanceById(long id) throws BalanceNotFoundException;

    Balance putBalance(long id, Balance input);

    Balance patchBalance(long id, Balance input) throws BalanceNotFoundException;

    void deleteBalance(long l) throws BalanceNotFoundException;
}
