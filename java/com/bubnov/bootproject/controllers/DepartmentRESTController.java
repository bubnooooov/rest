package com.bubnov.bootproject.controllers;

import com.bubnov.bootproject.dto.ItemDTODepartment;
import com.bubnov.bootproject.entities.Department;
import com.bubnov.bootproject.entities.Location;
import com.bubnov.bootproject.services.DepartmentService;
import com.bubnov.bootproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments/")
public class DepartmentRESTController {

    private DepartmentService departmentService;
    private LocationService locationService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public List<Department> getAllCountries() {
        return departmentService.findAllCountries();
    }

    @PostMapping("/")
    public Department addNewDepartment(@RequestBody ItemDTODepartment department) {
        if (department == null)
            throw new NullPointerException("Department not found");

        Department newDepartment = new Department();
        Location location = locationService.findLocationById(department.getLocationID());

        newDepartment.setDepartmentName(department.getDepartmentName());
        newDepartment.setDepartmentID(department.getDepartmentID());
        newDepartment.setLocationID(location);

        departmentService.saveOrUpdateDepartment(newDepartment);
        return newDepartment;
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable String id) {
        return departmentService.findDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@RequestBody ItemDTODepartment department, @PathVariable String id) {
        if (department == null)
            throw new NullPointerException("New department not found");

        Department newDepartment = new Department();
        Location location = locationService.findLocationById(department.getLocationID());

        newDepartment.setDepartmentName(department.getDepartmentName());
        newDepartment.setLocationID(location);
        newDepartment.setDepartmentID(id);

        departmentService.saveOrUpdateDepartment(newDepartment);
        return newDepartment;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return "Department with id " + id + " was deleted from database";
    }
}
