package com.cognizant.balancecrud.service;

import com.cognizant.balancecrud.exception.BalanceNotFoundException;
import com.cognizant.balancecrud.model.Balance;
import com.cognizant.balancecrud.repository.BalanceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BalanceCrudLogicTest {

    BalanceCrudLogic balanceService;
    BalanceRepo balanceRepo;

    @BeforeEach
    public void setUp() throws Exception {
        balanceRepo = mock(BalanceRepo.class);
        balanceService = new BalanceCrudLogicImpl(balanceRepo);
    }

    @Test
    public void getAll_ShouldCallRepo(){
        List<Balance> expected = Arrays.asList(
                new Balance(1L, 1, 1L, 2L),
                new Balance (2L, 1, 1L, 1L)
        );

        when(balanceRepo.findAll()).thenReturn(expected);

        List<Balance> actual = balanceService.findAll();

        verify(balanceRepo).findAll();
        assertEquals(expected, actual);

    }

    @Test
    public void getBalanceById_CallsRepoReturnsBalance() throws BalanceNotFoundException {

        Balance expected = new Balance(1L, 1, 1L, 1L);
        when(balanceRepo.findById(1L)).thenReturn(Optional.of(expected));

        Balance actual = balanceService.getBalanceById(1L);
        assertEquals(expected, actual);
        verify(balanceRepo).findById(1L);
    }

    @Test
    public void getBalanceById_ThrowsBalanceNotFoundExceptionWhenNotFound(){
        assertThrows(BalanceNotFoundException.class, () ->{
            balanceService.getBalanceById(101L);
        });
    }

    @Test
    public void putBalance_SavesToRepository(){
        Balance input = new Balance(null, 2, 1L, 1L);
        Balance expected = new Balance(1L, 2, 1L, 1L);

        balanceService.putBalance(1L, input);
        verify(balanceRepo).save(expected);
    }

    @Test
    public void putBalance_ReturnsRecord(){
        Balance input = new Balance(null, 2, 1L, 1L);
        Balance expected = new Balance(1L, 2, 1L, 1L);

        when(balanceRepo.save(expected)).thenReturn(expected);

        Balance actual = balanceService.putBalance(1L, input);
        assertEquals(expected, actual);
    }

    @Test
    public void patchBalance_updatesBalance() throws BalanceNotFoundException {
        Balance input = new Balance(null, 1, 1L, 1L);
        Balance fromRepo = new Balance(1L, 0, 1L, 1L);
        Balance expected = new Balance(1L, 1, 1L, 1L);

        when(balanceRepo.findById(1L)).thenReturn(Optional.of(fromRepo));
        when(balanceRepo.save(expected)).thenReturn(expected);

        Balance actual = balanceService.patchBalance(1L, input);

        assertEquals(expected, actual);
    }

    @Test
    public void deleteBalance_CallsRepo() throws BalanceNotFoundException {
        Balance fromRepo = new Balance(1L, 1, 1L, 1L);
        when(balanceRepo.findById(1L)).thenReturn(Optional.of(fromRepo));

        balanceService.deleteBalance(1L);

        verify(balanceRepo).delete(fromRepo);
    }

    @Test
    public void deleteBalance_ThrowsErrorWhenNoRecordFound(){
        when(balanceRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BalanceNotFoundException.class, ()-> {
            balanceService.deleteBalance(1L);
        });
    }
}