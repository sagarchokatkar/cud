package com.intellect.cud.response;

import java.util.Map;

import com.intellect.cud.model.Employee;

public class EmployeeResponse  {
	
	private String resMsg;
	
	private String userId;
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private Map<String,String> valErrors;

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, String> getValErrors() {
		return valErrors;
	}

	public void setValErrors(Map<String, String> valErrors) {
		this.valErrors = valErrors;
	}
	
	

}
