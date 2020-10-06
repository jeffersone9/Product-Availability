package com.cognizant.locationcrud.controller;

import com.cognizant.locationcrud.exception.LocationNotFoundException;
import com.cognizant.locationcrud.model.Location;
import com.cognizant.locationcrud.service.LocationCrudLogicImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LocationControllerTest {

    private LocationCrudLogicImpl locationService;
    private LocationController locationController;

    @BeforeEach
    public void setUp() throws Exception {
        locationService = Mockito.mock(LocationCrudLogicImpl.class);
        locationController = new LocationController(locationService);
    }

    @Test
    public void getAll_CallsService(){
        List<Location> expected = Arrays.asList(
                new Location(1L, "Baton Rouge", 70791),
                new Location(2L, "Ruston", 71270));

        when(locationService.getAll()).thenReturn(expected);
        ResponseEntity<List<Location>> actual = locationController.getAllLocations();

        verify(locationService).getAll();
        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void getLocationById_CallsServiceAndReturnsOk() throws LocationNotFoundException {
        Location expected = new Location(1L, "Baton Rouge", 70791);
        when(locationService.getLocationById(1L)).thenReturn(expected);

        ResponseEntity<Location> actual = locationController.getLocationById(1L);

        verify(locationService).getLocationById(1L);
        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void getLocationById_Returns404NoLocationFoundException() throws LocationNotFoundException {
        when(locationService.getLocationById(32L)).thenThrow(new LocationNotFoundException());

        ResponseEntity<Location> actual = locationController.getLocationById(32L);

        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        assertEquals(null, actual.getBody());
    }
}