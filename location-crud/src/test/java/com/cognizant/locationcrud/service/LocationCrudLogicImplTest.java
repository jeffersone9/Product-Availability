package com.cognizant.locationcrud.service;

import com.cognizant.locationcrud.exception.LocationNotFoundException;
import com.cognizant.locationcrud.model.Location;
import com.cognizant.locationcrud.repository.LocationRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LocationCrudLogicImplTest {

    private LocationRepo locationRepo;
    private LocationCrudLogicImpl locationService;

    @BeforeEach
    public void setUp() throws Exception {
        locationRepo = Mockito.mock(LocationRepo.class);
        locationService = new LocationCrudLogicImpl(locationRepo);
    }
    /**
     * Just need to get locations
     * (will use sql to input dummy data into db)
     */
    @Test
    public void getAll_CallsRepo(){
        List<Location> expected = Arrays.asList(
                new Location(1L, "Baton Rouge", 70791),
                new Location(2L, "Ruston", 71270)
        );

        when(locationRepo.findAll()).thenReturn(expected);

        List<Location> actual = locationService.getAll();
        verify(locationRepo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void getLocationById_ReturnsLocation() throws LocationNotFoundException {
        Location expected = new Location(1L, "Baton Rouge", 70791);
        when(locationRepo.findById(1L)).thenReturn(Optional.of(expected));

        Location actual = locationService.getLocationById(1L);
        assertEquals(expected, actual);
        verify(locationRepo).findById(1L);
    }

    @Test
    public void getLocationById_ThrowsLocationNotFoundException(){
        assertThrows(LocationNotFoundException.class, () ->{
            locationService.getLocationById(122L);
        });
    }
}