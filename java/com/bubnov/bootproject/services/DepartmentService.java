package com.bubnov.bootproject.services;

import com.bubnov.bootproject.entities.Department;
import com.bubnov.bootproject.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository repository;

    @Autowired
    public void setRepository(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> findAllCountries() {
        return repository.findAll();
    }

    public Department findDepartmentById(String id) {
        Optional<Department> department = repository.findById(id);
        return department.orElseGet(Department::new);
    }

    public void saveOrUpdateDepartment(Department department) {
        repository.save(department);
    }

    public boolean deleteDepartment(String id) {
        Department department = findDepartmentById(id);

        if (department != null) {
            repository.delete(department);
            return true;
        }

        else return false;
    }
}
