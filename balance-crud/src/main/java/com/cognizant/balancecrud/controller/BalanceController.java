package com.cognizant.balancecrud.controller;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.Balance;
import com.cognizant.balancecrud.service.BalanceCrudLogicImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    private final BalanceCrudLogicImpl balanceService;
    public BalanceController(BalanceCrudLogicImpl balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public ResponseEntity<List<Balance>> getAllBalances() {
        return new ResponseEntity<>(balanceService.findAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Balance> getBalanceById(@PathVariable("id") long id) throws BalanceNotFoundException {
        try{
            return new ResponseEntity<>(balanceService.getBalanceById(id), OK);
        } catch(BalanceNotFoundException e){
            return new ResponseEntity<>(null, NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Balance> patchBalance(@PathVariable("id") long id, @RequestBody Balance input) throws BalanceNotFoundException {
        try{
            return new ResponseEntity<>(balanceService.patchBalance(id, input), OK);
        }catch(BalanceNotFoundException e){
            return new ResponseEntity<>(null, NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Balance> putBalance(@PathVariable long id, @RequestBody Balance balance) {
        return new ResponseEntity<>(balanceService.putBalance(id, balance), CREATED);
    }
}
