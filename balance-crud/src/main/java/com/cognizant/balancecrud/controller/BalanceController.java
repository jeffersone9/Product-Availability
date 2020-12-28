package com.cognizant.balancecrud.controller;


import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.Balance;
import com.cognizant.balancecrud.model.BalanceDB;
import com.cognizant.balancecrud.service.BalanceCrudLogic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/balances")
public class BalanceController {

    private final BalanceCrudLogic balanceService;

    public BalanceController(BalanceCrudLogic balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public ResponseEntity<List<BalanceDB>> getAllBalances() {
        return new ResponseEntity<>(balanceService.findAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceDB> getBalanceById(@PathVariable("id") long id) throws BalanceNotFoundException {
        try{
            return new ResponseEntity<>(balanceService.getBalanceById(id), OK);
        } catch(BalanceNotFoundException e){
            return new ResponseEntity<>(null, NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BalanceDB> patchBalance(@PathVariable("id") long id, @RequestBody BalanceDB input) throws BalanceNotFoundException {
        try{
            return new ResponseEntity<>(balanceService.patchBalance(id, input), OK);
        }catch(BalanceNotFoundException e){
            return new ResponseEntity<>(null, NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BalanceDB> putBalance(@PathVariable long id, @RequestBody BalanceDB balanceDB) {
        return new ResponseEntity<>(balanceService.putBalance(id, balanceDB), CREATED);
    }
}
