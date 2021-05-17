package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Manager {

    @Id
    @Column(name = "employee_id",    length = 6)
    private int employeeID;

    @Column(name = "first_name",     length = 20)                   private String firstName;
    @Column(name = "last_name",      length = 25, nullable = false) private String lastName;
    @Column(name = "email",          length = 25, nullable = false) private String email;
    @Column(name = "phone_number",   length = 20)                   private String phoneNumber;
    @Column(name = "salary",         length = 8)                    private Double salary;
    @Column(name = "commission_pct", length = 2)                    private Double commissionPct;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hire_date",                   nullable = false) private Date hireDate;

    public Manager() { }

    public Manager(String firstName, String lastName, String email, String phoneNumber,
                   Date hireDate, Double salary, Double commissionPct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
    }
}

