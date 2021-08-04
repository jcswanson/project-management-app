package com.jcs.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcs.pma.dao.EmployeeRepository;
import com.jcs.pma.dao.ProjectRepository;
import com.jcs.pma.dto.ChartData;
import com.jcs.pma.dto.EmployeeProject;
import com.jcs.pma.entities.Project;
import com.jcs.pma.springbean.Car;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	// bean method inserted into Main class or better yet a SpringConfig class
    @Autowired 
	Car newCar;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		// Accessing the version number in the application.properties
		model.addAttribute("versionNumber", ver);
		
		// we are querying the db for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		//add stage count for pie chart
		List<ChartData> chartDataValues = proRepo.getProjectStatus();

		// convert above chart data to json for js use
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartDataValues);
		// json -> [["NOTSTARTED", 1], ["INPROGRESS", 2], ...]
		// send to the model or DOM so js can parse out the json string
		model.addAttribute("chartDataStatus", jsonString);
		
		// querying db for employees
		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeeListProjectsCnt", employeesProjectCnt);
		
		return "main/home";
	}
}
