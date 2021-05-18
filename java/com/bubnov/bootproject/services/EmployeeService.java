package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Employee;
import com.bubnov.bootproject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    public Employee findEmployeeById(int id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) return employee.get();
        else throw new NullPointerException("Employee with id " + id + " not found in database");
    }

    public void saveOrUpdateEmployee(Employee employee) {
        repository.save(employee);
    }

    public void deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);
        repository.delete(employee);
    }
}
