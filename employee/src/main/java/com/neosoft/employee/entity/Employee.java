package com.neosoft.employee.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Document(collection = "employee")
public class Employee {
    @Id
    @Indexed(unique = true)
    private int empId;
    private String empName;
    private String empDob;
    private String empDesignation;
}
