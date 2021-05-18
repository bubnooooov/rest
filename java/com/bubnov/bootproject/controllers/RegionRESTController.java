package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.entities.Region;
import com.bubnov.bootproject.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionRESTController {

    private RegionService service;

    @Autowired
    public void setService(RegionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Region> getAllRegions() {
        return service.findAllRegions();
    }

    @PostMapping("/")
    public Region addNewRegion(@RequestBody Region region) {
        if (region == null)
            throw new NullPointerException("Region not found");
        service.saveOrUpdateRegion(region);
        return region;
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable int id) { return service.findRegionById(id); }

    @PutMapping("/{id}")
    public Region updateRegion(@RequestBody Region newRegion, @PathVariable int id) {
        if (newRegion == null)
            throw new NullPointerException("New region not found");
        newRegion.setRegionID(id);

        service.saveOrUpdateRegion(newRegion);
        return newRegion;
    }

    @DeleteMapping("/{id}")
    public String deleteRegion(@PathVariable int id) {
        service.deleteRegion(id);
        return "Region with id " + id + " was deleted from database";
    }
}
