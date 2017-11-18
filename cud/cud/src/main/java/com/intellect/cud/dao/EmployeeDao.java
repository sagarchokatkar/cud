package com.intellect.cud.dao;

import com.intellect.cud.model.Employee;

public interface EmployeeDao {
  public Employee saveEmployee(Employee createEmployeeRequest);
  public Employee updateEmployee(Employee createEmployeeRequest);
  public Boolean removeEmployee(String employeeId);
  public Boolean isEmployeeAlreadyExist(Employee employee);
  
}
