package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.dto.ItemDTOCountry;
import com.bubnov.bootproject.entities.Country;
import com.bubnov.bootproject.entities.Region;
import com.bubnov.bootproject.services.CountryService;
import com.bubnov.bootproject.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/countries")
public class CountryRESTController {

    private CountryService countryService;
    private RegionService regionService;

    @Autowired
    public void setService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setRegionService(RegionService regionService) { this.regionService = regionService; }

    @GetMapping("/")
    public List<Country> getAllCountries() {
        return countryService.findAllCountries();
    }

    @PostMapping("/")
    public Country addNewCountry(@RequestBody ItemDTOCountry country) {
        if (country == null)
            throw new NullPointerException("Country not found");

        Country newCountry = new Country();
        Region region = regionService.findRegionById(country.getRegionID());

        newCountry.setCountryID(country.getCountryID().toUpperCase(Locale.ROOT));
        newCountry.setCountryName(country.getCountryName());
        newCountry.setRegionID(region);

        countryService.saveOrUpdateCountry(newCountry);
        return newCountry;
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable String id) {
        return countryService.findCountryById(id.toUpperCase(Locale.ROOT));
    }

    @PutMapping("/{id}")
    public Country updateCountry(@RequestBody ItemDTOCountry country, @PathVariable String id) {
        if (country == null)
            throw new NullPointerException("New region not found");

        Country newCountry = new Country();
        Region region = regionService.findRegionById(country.getRegionID());

        newCountry.setCountryID(id.toUpperCase(Locale.ROOT));
        newCountry.setCountryName(country.getCountryName());
        newCountry.setRegionID(region);

        countryService.saveOrUpdateCountry(newCountry);
        return newCountry;
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable String id) {
        countryService.deleteCountry(id.toUpperCase(Locale.ROOT));
        return "Country with id " + id + " was deleted from database";
    }
}
