package com.cognizant.balancecrud.controller;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.Balance;
import com.cognizant.balancecrud.service.BalanceCrudLogicImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

public class BalanceControllerTest {

    BalanceController balanceController;
    BalanceCrudLogicImpl balanceService;

    @BeforeEach
    public void setUp() throws Exception {
        balanceService = mock(BalanceCrudLogicImpl.class);
        balanceController = new BalanceController(balanceService);
    }

    @Test
    public void getAll_CallsService(){

        List<Balance> expected = Arrays.asList(
                new Balance(1L, 1, 1L,1L),
                new Balance(2L, 1, 1L, 1L)
        );
        when(balanceService.findAll()).thenReturn(expected);

        List<Balance> actual = balanceController.getAllBalances().getBody();

        verify(balanceService).findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void getBalanceById_CallsServiceReturnsOK() throws BalanceNotFoundException {
        Balance expected = new Balance(1L, 1, 1L, 1L);
        when(balanceService.getBalanceById(1L)).thenReturn(expected);

        ResponseEntity<Balance> response = balanceController.getBalanceById(1L);

        verify(balanceService).getBalanceById(1L);
        assertEquals(expected, response.getBody());
        assertEquals(OK, response.getStatusCode());
    }

    @Test
    public void getBalanceById_Returns404WhenNotFound() throws BalanceNotFoundException {
        when(balanceService.getBalanceById(4L)).thenThrow(new BalanceNotFoundException());

        ResponseEntity<Balance> response = balanceController.getBalanceById(4L);

        assertEquals(NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void patchBalance_ReturnsUpdatedAndOk() throws BalanceNotFoundException {
        Balance input = new Balance(null, 1, 1L, 1L);
        Balance expected = new Balance(1L, 1, 1L, 1L);
        when(balanceService.patchBalance(1L, input)).thenReturn(expected);

        ResponseEntity<Balance> response = balanceController.patchBalance(1L, input);

        verify(balanceService).patchBalance(1L, input);
        assertEquals(expected, response.getBody());
        assertEquals(OK, response.getStatusCode());
    }

    @Test
    public void patchBalance_Returns404_WhenBalanceNotFoundException() throws BalanceNotFoundException {
        Balance input = new Balance();
        when(balanceService.patchBalance(3L, input)).thenThrow(new BalanceNotFoundException());

        ResponseEntity<Balance> response = balanceController.patchBalance(3L, input);

        assertEquals(NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void putBalance_ReturnsNewRecordAndCreated(){
        Balance expected = new Balance(4L, 2, 1L, 1L);
        when(balanceService.putBalance(4L, expected)).thenReturn(expected);

        ResponseEntity<Balance> response = balanceController.putBalance(4L, expected);

        verify(balanceService).putBalance(4L, expected);
        assertEquals(expected, response.getBody());
        assertEquals(CREATED, response.getStatusCode());
    }
}