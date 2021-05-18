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

    public List<Job> findAllJobs() {
        return repository.findAll();
    }

    public Job findJobById(String id) {
        Optional<Job> job = repository.findById(id);
        if (job.isPresent()) return job.get();
        else throw new NullPointerException("Job with id " + id + " not found in database");
    }

    public void saveOrUpdateJob(Job job) {
        repository.save(job);
    }

    public void deleteJob(String id) {
        Job job = findJobById(id);
        repository.delete(job);
    }
}
