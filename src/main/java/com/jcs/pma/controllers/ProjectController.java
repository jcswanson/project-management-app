package com.jcs.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcs.pma.dao.EmployeeRepository;
import com.jcs.pma.dao.ProjectRepository;
import com.jcs.pma.entities.Employee;
import com.jcs.pma.entities.Project;

@Controller //Used for html names in templates folder, @RestController methods aren't binded to templates
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRepo;
	
	
	EmployeeRepository empRepo;
	
	//Setter Injection
	@Autowired
	public void setEmpRepo(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@GetMapping  // this GETs the classes RequestMapping("/projects") URI
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	

	

	@GetMapping("/new") //replaces @RequestMapping(value="/new", method=RequestMethod.GET)
	public String displayProjectForm(Model model) { 
		
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		//Model can be ModelMap as well as it is a hash map
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		return "projects/new-project";
		
	}
	
	@PostMapping("/save") //replaces @RequestMapping(value="/save", method=RequestMethod.POST)
	public String createProject(Project project,  Model model) { 
		
		// should handle saving to the database with CRUD repo
		proRepo.save(project);
		
		/*
		 * *Used for OneToMany Relationship w/ @RequestParam List<Long> employees*
		 * Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
		 * 
		 * for(Employee emp : chosenEmployees) {
		 *  // setting relationship in the db using the foreign key
		 *  	emp.setProject(project); 
		 *  // save each employee's status as well
		 *  	empRepo.save(emp); 
		 *  }
		 */
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";	
	}
	
	
	
}
