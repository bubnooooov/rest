package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries/")
public class CountryRESTController {

    private CountryService service;

    @Autowired
    public void setService(CountryService service) {
        this.service = service;
    }
}
