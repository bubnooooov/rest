package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "job_id",     length = 10)
    private String jobID;

    @Column(name = "job_title", nullable = false) private String jobTitle;
    @Column(name = "min_salary", length = 6)      private Integer minSalary;
    @Column(name = "max_salary", length = 6)      private Integer maxSalary;

    public Job() { }

    public Job(String jobTitle, Integer minSalary, Integer maxSalary) {
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
}
