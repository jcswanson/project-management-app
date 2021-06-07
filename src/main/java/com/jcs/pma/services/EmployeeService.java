package com.jcs.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jcs.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {

	// Qualifier is to identify which class is the Bean, not an issue unless 
//	   more than one class is implementing the interface 
	@Qualifier("employeeRepository")
	@Autowired
	EmployeeRepository empRepoFI; // Field Injection
	
	EmployeeRepository empRepoSI; // Setter Injection
	
	EmployeeRepository empRepoCI; // Constructor Injection
	
	public EmployeeService(EmployeeRepository empRepoCI) {
		this.empRepoCI = empRepoCI;
	}

	
	
	@Autowired
	public void setEmpRepoSI(EmployeeRepository empRepoSI) {
		this.empRepoSI = empRepoSI;
	}

}
