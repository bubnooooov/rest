package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Region;
import com.bubnov.bootproject.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private RegionRepository repository;

    @Autowired
    public void setRepository(RegionRepository repository) {
        this.repository = repository;
    }

    public List<Region> findAllRegions() {
        return repository.findAll();
    }

    public Region findRegionById(int id) {
        Optional<Region> region = repository.findById(id);
        if (region.isPresent()) return region.get();
        else throw new NullPointerException("Region with id " + id + " not found in database");
    }

    public void saveOrUpdateRegion(Region region) {
        repository.save(region);
    }

    public void deleteRegion(int id) {
        Region region = findRegionById(id);
        repository.delete(region);
    }
}
