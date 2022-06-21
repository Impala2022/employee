package com.neosoft.employee.service;

import com.neosoft.employee.entity.Employee;
import com.neosoft.employee.repo.EmployeeRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepoImpl employeeRepo;
    public int create(Employee details){
        employeeRepo.save(details);
        return details.getEmpId();
    }
}
