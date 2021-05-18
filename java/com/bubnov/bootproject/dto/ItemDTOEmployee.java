package com.bubnov.bootproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ItemDTOEmployee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Double salary;
    private Double commissionPct;
    private Date hireDate;
    private String jobNameID;
    private Integer managerID;
    private String departmentID;
}
