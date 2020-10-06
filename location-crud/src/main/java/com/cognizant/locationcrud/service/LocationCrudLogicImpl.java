package com.cognizant.locationcrud.service;

import com.cognizant.locationcrud.exception.LocationNotFoundException;
import com.cognizant.locationcrud.model.Location;
import com.cognizant.locationcrud.repository.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationCrudLogicImpl implements LocationCrudLogic {
    private LocationRepo locationRepo;
    public LocationCrudLogicImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }


    @Override
    public List<Location> getAll() {

        return locationRepo.findAll();
    }

    @Override
    public Location getLocationById(long id) throws LocationNotFoundException {
        Optional<Location> optional =  locationRepo.findById(1L);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new LocationNotFoundException();
    }
}
