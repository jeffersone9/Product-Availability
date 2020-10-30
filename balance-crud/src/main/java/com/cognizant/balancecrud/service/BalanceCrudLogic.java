package com.cognizant.balancecrud.service;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.BalanceDB;

import java.util.List;

public interface BalanceCrudLogic {
    List<BalanceDB> findAll();

    BalanceDB getBalanceById(long id) throws BalanceNotFoundException;

    BalanceDB putBalance(long id, BalanceDB input);

    BalanceDB patchBalance(long id, BalanceDB input) throws BalanceNotFoundException;

    void deleteBalance(long l) throws BalanceNotFoundException;
}
