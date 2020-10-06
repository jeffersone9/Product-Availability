package com.cognizant.locationcrud.controller;

import com.cognizant.locationcrud.exception.LocationNotFoundException;
import com.cognizant.locationcrud.model.Location;
import com.cognizant.locationcrud.service.LocationCrudLogicImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    LocationCrudLogicImpl locationService;

    public LocationController(LocationCrudLogicImpl locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return new ResponseEntity<>(locationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(long id) throws LocationNotFoundException {
        try{
            return new ResponseEntity<>(locationService.getLocationById(id), HttpStatus.OK);
        } catch(LocationNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
