package com.neosoft.employee.service;

import com.neosoft.employee.entity.Employee;
import com.neosoft.employee.kafka.CallBack;
import com.neosoft.employee.kafka.EmployeeProducer;
import com.neosoft.employee.repo.EmployeeRepoImpl;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepoImpl employeeRepo;
    public int create(Employee details){
        employeeRepo.save(details);
        EmployeeProducer kafkaProducer=new EmployeeProducer("Employee",details.toString());
        kafkaProducer.start();
        return details.getEmpId();
    }
}
