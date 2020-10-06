package com.cognizant.locationcrud.service;

import com.cognizant.locationcrud.exception.LocationNotFoundException;
import com.cognizant.locationcrud.model.Location;

import java.util.List;

public interface LocationCrudLogic {
    List<Location> getAll();

    Location getLocationById(long id) throws LocationNotFoundException;
}
