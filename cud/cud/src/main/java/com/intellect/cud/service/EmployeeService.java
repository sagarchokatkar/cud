package com.intellect.cud.service;

import org.springframework.http.ResponseEntity;

import com.intellect.cud.model.Employee;
import com.intellect.cud.response.EmployeeResponse;

public interface EmployeeService {
     ResponseEntity<EmployeeResponse> createEmployee(Employee createEmployeeRequest);
//     ResponseEntity<EmployeeResponse> updateEmployee(Employee createEmployeeRequest);
     ResponseEntity<EmployeeResponse> deleteEmployee(String employeeId);

}
