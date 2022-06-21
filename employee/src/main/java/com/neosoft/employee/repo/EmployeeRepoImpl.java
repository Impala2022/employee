package com.neosoft.employee.repo;

import com.neosoft.employee.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepoImpl extends MongoRepository<Employee,Integer> {
     Employee findByEmpId(int id);
     long deleteByEmpId(int id);
}
