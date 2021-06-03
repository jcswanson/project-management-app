package com.jcs.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcs.pma.dao.EmployeeRepository;
import com.jcs.pma.entities.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new") 
	public String displayEmployeeForm(Model model) { 
		Employee newEmployee = new Employee();
		model.addAttribute("employee", newEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save") 
	public String createEmployee(Employee employee, Model model) { 
		// should handle saving to the database with CRUD repo
		empRepo.save(employee);
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees";
		
	}
}
