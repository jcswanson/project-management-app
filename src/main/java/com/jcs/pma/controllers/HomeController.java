package com.jcs.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jcs.pma.dao.EmployeeRepository;
import com.jcs.pma.dao.ProjectRepository;
import com.jcs.pma.entities.Employee;
import com.jcs.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		// we are querying the db for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		// querying db for employees
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		
		return "main/home";
	}
}
