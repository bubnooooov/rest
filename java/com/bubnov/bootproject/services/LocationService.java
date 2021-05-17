package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Location;
import com.bubnov.bootproject.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private LocationRepository repository;

    @Autowired
    public void setRepository(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAllCountries() {
        return repository.findAll();
    }

    public Location findLocationById(int id) {
        Optional<Location> location = repository.findById(id);
        return location.orElseGet(Location::new);
    }

    public void saveOrUpdateLocation(Location location) {
        repository.save(location);
    }

    public boolean deleteLocation(int id) {
        Location location = findLocationById(id);

        if (location != null) {
            repository.delete(location);
            return true;
        }

        else return false;
    }
}
