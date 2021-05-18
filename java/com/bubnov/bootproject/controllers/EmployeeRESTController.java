package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.dto.ItemDTOEmployee;
import com.bubnov.bootproject.entities.*;
import com.bubnov.bootproject.services.DepartmentService;
import com.bubnov.bootproject.services.EmployeeService;
import com.bubnov.bootproject.services.JobService;
import com.bubnov.bootproject.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRESTController {

    private DepartmentService departmentService;
    private EmployeeService employeeService;
    private ManagerService managerService;
    private JobService jobService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() { return employeeService.findAllEmployees(); }

    @PostMapping("/")
    public Employee addNewEmployee(@RequestBody ItemDTOEmployee employee) {
        if (employee == null)
            throw new NullPointerException("Employee not found");

        Employee newEmployee = new Employee();
        Department department = departmentService.findDepartmentById(employee.getDepartmentID());
        Job job = jobService.findJobById(employee.getJobNameID().toUpperCase(Locale.ROOT));
        Manager manager = managerService.findManagesById(employee.getManagerID());

        newEmployee.setCommissionPct(employee.getCommissionPct());
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        newEmployee.setEmployeeID(employee.getEmployeeID());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setHireDate(employee.getHireDate());
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setDepartmentID(department);
        newEmployee.setManager(manager);
        newEmployee.setJobNameID(job);

        employeeService.saveOrUpdateEmployee(newEmployee);
        return newEmployee;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody ItemDTOEmployee employee, @PathVariable int id) {
        if (employee == null)
            throw new NullPointerException("Employee not found");

        Employee newEmployee = new Employee();
        Department department = departmentService.findDepartmentById(employee.getDepartmentID());
        Job job = jobService.findJobById(employee.getJobNameID().toUpperCase(Locale.ROOT));
        Manager manager = managerService.findManagesById(employee.getManagerID());

        newEmployee.setCommissionPct(employee.getCommissionPct());
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setHireDate(employee.getHireDate());
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setDepartmentID(department);
        newEmployee.setManager(manager);
        newEmployee.setEmployeeID(id);
        newEmployee.setJobNameID(job);

        employeeService.saveOrUpdateEmployee(newEmployee);
        return newEmployee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted from database";
    }
}
