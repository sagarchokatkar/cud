package com.intellect.cud.service;

import java.awt.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.intellect.cud.dao.EmployeeDao;
import com.intellect.cud.dao.EmployeeDaoImpl;
import com.intellect.cud.model.Employee;
import com.intellect.cud.response.EmployeeResponse;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public ResponseEntity<EmployeeResponse> createEmployee(Employee createEmployeeRequest) {
		EmployeeResponse createEmployeeResponse = new EmployeeResponse();
		Employee emp=null;
		if(employeeDao.isEmployeeAlreadyExist(createEmployeeRequest)){
			createEmployeeResponse.setUserId(createEmployeeRequest.getId());
			createEmployeeResponse.setResMsg("employee with the given email id already exist,Updated employee");
			emp=employeeDao.updateEmployee(createEmployeeRequest);
			createEmployeeResponse.setEmployee(emp);
		}else{
			emp=employeeDao.saveEmployee(createEmployeeRequest);
			createEmployeeResponse.setEmployee(emp);
			createEmployeeResponse.setUserId(emp.getId());
			createEmployeeResponse.setResMsg("employee with the user id "+emp.getId()+" created successfully");
		}
		return new ResponseEntity<>(createEmployeeResponse, HttpStatus.OK);
	}



	@Override
	public ResponseEntity<EmployeeResponse> deleteEmployee(String employeeId) {
		logger.debug("entering inside deleteEmployee(String employeeId) method");
		logger.debug("Delete Employee Request : {} ", employeeId);
		EmployeeResponse deleteResponse = new EmployeeResponse(); 
		if(!employeeDao.isEmployeeAlreadyExist(new Employee(employeeId))){
			deleteResponse.setUserId(employeeId);
			deleteResponse.setResMsg("employee to be deleted with given if not found");
		}else{
		if(employeeDao.removeEmployee(employeeId)){
			deleteResponse.setUserId(employeeId);
			deleteResponse.setResMsg("employee successfully deleted with given id");
		}else{
			deleteResponse.setUserId(employeeId);
			deleteResponse.setResMsg("employee deletion with given id failed");
		}
		}
		return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
	}
}
