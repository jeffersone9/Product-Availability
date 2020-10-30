package com.cognizant.balancecrud.service;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.BalanceDB;
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
    public List<BalanceDB> findAll() {
        return balanceRepo.findAll();
    }

    @Override
    public BalanceDB getBalanceById(long id) throws BalanceNotFoundException {
        Optional<BalanceDB> optional = balanceRepo.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new BalanceNotFoundException();
    }

    @Override
    public BalanceDB putBalance(long id, BalanceDB balanceDB) {

        balanceDB.setId(id);
        return balanceRepo.save(balanceDB);
    }

    @Override
    public BalanceDB patchBalance(long id, BalanceDB balanceDB) throws BalanceNotFoundException {
        Optional<BalanceDB> optional = balanceRepo.findById(id);
        if(optional.isEmpty()){
            throw new BalanceNotFoundException();
        }

        BalanceDB balanceUpdate = optional.get();

        balanceUpdate.setBalance(balanceDB.getBalance());

        return balanceRepo.save(balanceUpdate);
    }

    @Override
    public void deleteBalance(long id) throws BalanceNotFoundException {
        Optional<BalanceDB> optional = balanceRepo.findById(id);
        if(optional.isEmpty()){
            throw new BalanceNotFoundException();
        }
        balanceRepo.delete(optional.get());
    }
}
