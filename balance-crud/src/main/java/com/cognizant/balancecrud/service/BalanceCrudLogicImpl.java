package com.cognizant.balancecrud.service;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.Balance;
import com.cognizant.balancecrud.repository.BalanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceCrudLogicImpl implements BalanceCrudLogic {

    private final BalanceRepo balanceRepo;

    public BalanceCrudLogicImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @Override
    public List<Balance> findAll() {
        return balanceRepo.findAll();
    }

    @Override
    public Balance getBalanceById(long id) throws BalanceNotFoundException {
        Optional<Balance> optional = balanceRepo.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new BalanceNotFoundException();
    }

    @Override
    public Balance putBalance(long id, Balance balance) {

        balance.setId(id);
        return balanceRepo.save(balance);
    }

    @Override
    public Balance patchBalance(long id, Balance balance) throws BalanceNotFoundException {
        Optional<Balance> optional = balanceRepo.findById(id);
        if(optional.isEmpty()){
            throw new BalanceNotFoundException();
        }

        Balance balanceUpdate = optional.get();

        balanceUpdate.setBalance(balance.getBalance());

        return balanceRepo.save(balanceUpdate);
    }

    @Override
    public void deleteBalance(long id) throws BalanceNotFoundException {
        Optional<Balance> optional = balanceRepo.findById(id);
        if(optional.isEmpty()){
            throw new BalanceNotFoundException();
        }
        balanceRepo.delete(optional.get());
    }
}
