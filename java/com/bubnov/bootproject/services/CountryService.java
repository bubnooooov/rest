package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Country;
import com.bubnov.bootproject.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository repository;

    @Autowired
    public void setRepository(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> findAllCountries() {
        return repository.findAll();
    }

    public Country findCountryById(String id) {
        Optional<Country> country = repository.findById(id);
        if (country.isPresent()) return country.get();
        else throw new NullPointerException("Country with id " + id + " not found in database");
    }

    public void saveOrUpdateCountry(Country country) {
        repository.save(country);
    }

    public void deleteCountry(String id) {
        Country country = findCountryById(id);
        repository.delete(country);
    }
}
