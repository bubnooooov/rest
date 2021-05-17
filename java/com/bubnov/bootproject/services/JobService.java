package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Job;
import com.bubnov.bootproject.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private JobRepository repository;

    @Autowired
    public void setRepository(JobRepository repository) {
        this.repository = repository;
    }

    public List<Job> findAllCountries() {
        return repository.findAll();
    }

    public Job findJobById(String id) {
        Optional<Job> job = repository.findById(id);
        return job.orElseGet(Job::new);
    }

    public void saveOrUpdateJob(Job job) {
        repository.save(job);
    }

    public boolean deleteJob(String id) {
        Job job = findJobById(id);

        if (job != null) {
            repository.delete(job);
            return true;
        }

        else return false;
    }
}
