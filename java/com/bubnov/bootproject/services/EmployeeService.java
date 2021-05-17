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

    public List<Employee> findAllCountries() {
        return repository.findAll();
    }

    public Employee findEmployeeById(int id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.orElseGet(Employee::new);
    }

    public void saveOrUpdateEmployee(Employee employee) {
        repository.save(employee);
    }

    public boolean deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            repository.delete(employee);
            return true;
        }

        else return false;
    }
}
