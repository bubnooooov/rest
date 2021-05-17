package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id",   length = 4)
    private String departmentID;

    @Column(name = "department_name", length = 30, nullable = false)
    private String departmentName;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "location_id")
    private Location locationID;

    public Department() { }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
