package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.dto.ItemDTOLocation;
import com.bubnov.bootproject.entities.Country;
import com.bubnov.bootproject.entities.Location;
import com.bubnov.bootproject.services.CountryService;
import com.bubnov.bootproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/locations/")
public class LocationRESTController {

    private LocationService locationService;
    private CountryService countryService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public List<Location> getAllLocations() {
        return locationService.findAllCountries();
    }

    @PostMapping("/")
    public Location addNewLocation(@RequestBody ItemDTOLocation location) {
        if (location == null)
            throw new NullPointerException("Location not found");

        Location newLocation = new Location();
        Country country = countryService.findCountryById(location.getCountryID().toUpperCase(Locale.ROOT));

        newLocation.setLocationAddress(location.getLocationAddress());
        newLocation.setStateProvince(location.getStateProvince());
        newLocation.setPostalCode(location.getPostalCode());
        newLocation.setLocationID(location.getLocationID());
        newLocation.setCity(location.getCity());
        newLocation.setCountryID(country);

        locationService.saveOrUpdateLocation(newLocation);
        return newLocation;
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable int id) {
        return locationService.findLocationById(id);
    }

    @PutMapping("/{id}")
    public Location updateLocation(@RequestBody ItemDTOLocation location, @PathVariable int id) {
        if (location == null)
            throw new NullPointerException("New location not found");

        Location newLocation = new Location();
        Country country = countryService.findCountryById(location.getCountryID().toUpperCase(Locale.ROOT));

        newLocation.setLocationAddress(location.getLocationAddress());
        newLocation.setStateProvince(location.getStateProvince());
        newLocation.setPostalCode(location.getPostalCode());
        newLocation.setCity(location.getCity());
        newLocation.setCountryID(country);
        newLocation.setLocationID(id);

        locationService.saveOrUpdateLocation(newLocation);
        return newLocation;
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable int id) {
        locationService.deleteLocation(id);
        return "Location with id " + id + " was deleted from database";
    }
}
