package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Manager;
import com.bubnov.bootproject.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    private ManagerRepository repository;

    @Autowired
    public void setRepository(ManagerRepository repository) {
        this.repository = repository;
    }

    public Manager findManagesById(int id) {
        Optional<Manager> manager = repository.findById(id);
        if (manager.isPresent()) return manager.get();
        else throw new NullPointerException("Manager with id " + id + " not found in database");
    }
}
