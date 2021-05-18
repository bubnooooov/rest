package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    // already in my db exist 206 entity, => initialValue = 207
    @SequenceGenerator(name = "jpaSequenceEmployee", sequenceName = "JPA_SEQUENCE_Employee",
                       allocationSize = 1, initialValue = 207)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceEmployee")
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "job_id",                  nullable = false)
    private Job jobNameID;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="manager_id")
    private Manager manager;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "department_id")
    private Department departmentID;

    public Employee() { }

    public Employee(String firstName, String lastName, String email, String phoneNumber,
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

