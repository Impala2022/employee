package com.neosoft.employee.controller;

import com.neosoft.employee.entity.Employee;
import com.neosoft.employee.repo.EmployeeRepoImpl;
import com.neosoft.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepoImpl employeeRepo;
    private Object repository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createEmployee(@RequestBody Employee employee) {
        int count=0;
        if(employee==null){
            throw new RuntimeException("Request is null");
        }else{
            count=employeeService.create(employee);
        }
        return count+":Employee Details Added Successfully";
    }
    @GetMapping("/searchAll")
    public List<Employee> searchEmployee(){
        return employeeRepo.findAll();
    }
    @GetMapping("/search")
    public Employee searchById(@RequestParam Integer id) {
        return employeeRepo.findByEmpId(id);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteEmployee(@RequestParam Integer empId){
         long temp=employeeRepo.deleteByEmpId(empId);
         return empId+" :Deleted";
    }
    @PostMapping("/update")
    @ResponseBody
    public String updateEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return "Employee details updated with id: "+employee.getEmpId();
    }
}
