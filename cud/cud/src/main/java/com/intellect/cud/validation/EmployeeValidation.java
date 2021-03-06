package com.intellect.cud.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.intellect.cud.model.Employee;
import com.intellect.cud.response.EmployeeResponse;

public class EmployeeValidation {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeValidation.class);
	
	public static EmployeeResponse isInvalidcreateEmployeeRequest(Employee createEmployeeRequest){
		
		EmployeeResponse createEmployeeResponse = new EmployeeResponse();
		if(null == createEmployeeRequest){
			createEmployeeResponse.setResMsg("Employee creation failed, required parameters are missing");
			return createEmployeeResponse;
		}
		return createEmployeeResponse;
	}
	
}
