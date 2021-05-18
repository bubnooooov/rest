package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.entities.Job;
import com.bubnov.bootproject.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/jobs")
public class JobRESTController {

    private JobService service;

    @Autowired
    public void setService(JobService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Job> getAllJobs() {
        return service.findAllJobs();
    }

    @PostMapping("/")
    public Job addNewJob(@RequestBody Job job) {
        if (job == null)
            throw new NullPointerException("Job not found");

        job.setJobID(job.getJobID().toUpperCase(Locale.ROOT));
        job.setJobTitle(job.getJobTitle().toUpperCase(Locale.ROOT));

        service.saveOrUpdateJob(job);
        return job;
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable String id) { return service.findJobById(id.toUpperCase(Locale.ROOT)); }

    @PutMapping("/{id}")
    public Job updateJob(@RequestBody Job newJob, @PathVariable String id) {
        if (newJob == null)
            throw new NullPointerException("New job not found");
        newJob.setJobID(id.toUpperCase(Locale.ROOT));

        service.saveOrUpdateJob(newJob);
        return newJob;
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable String id) {
        service.deleteJob(id.toUpperCase(Locale.ROOT));
        return "Job with id " + id + " was deleted from database";
    }
}
