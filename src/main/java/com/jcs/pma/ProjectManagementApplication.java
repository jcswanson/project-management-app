package com.jcs.pma;

/*import javax.activation.DataSource;*/
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.jcs.pma.dao.EmployeeRepository;
import com.jcs.pma.dao.ProjectRepository;
import com.jcs.pma.springbean.Car;
import com.jcs.pma.springbean.Doors;
import com.jcs.pma.springbean.Engine;
import com.jcs.pma.springbean.Tires;

/*
 * ScanBasePackages used to have Spring scan packages that aren't a child of 
 * the parent main package. Must include the main package too.
*/
@SpringBootApplication //(scanBasePackages= {"com.jcs.pma", "com.jcs.utils"})
public class ProjectManagementApplication {

	  // Autowired known as a Field Injection
	  @Autowired 
	  ProjectRepository proRepo;
	  
	  @Autowired 
	  EmployeeRepository empRepo;
	 

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}	


	// Setting the filename for the SQL Scripts
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource ds) {
	    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
	    resourceDatabasePopulator.addScript(new ClassPathResource("/schema.sql"));

	    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
	    dataSourceInitializer.setDataSource(ds);
	    dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
	    return dataSourceInitializer;
	}
	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		return new Car(e, d, t);
	}
	
	/*
	 * @Bean CommandLineRunner runner() { return args -> { Employee emp1 = new
	 * Employee("John", "Warton", "warton@gmail.com"); Employee emp2 = new
	 * Employee("Mike", "Lanister", "lanister@gmail.com"); Employee emp3 = new
	 * Employee("Steve", "Reeves", "Reeves@gmail.com");
	 * 
	 * Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
	 * Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com"); Employee
	 * emp6 = new Employee("Peter", "Henley", "henley@gmail.com");
	 * 
	 * Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
	 * Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com"); Employee
	 * emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");
	 * 
	 * 
	 * Project pro1 = new Project("Large Production Deploy", "NOTSTARTED",
	 * "This requires all hands on deck for" +
	 * "the final deployment of the software into production"); Project pro2 = new
	 * Project("New Employee Budget", "COMPLETED",
	 * "Decide on a new employee bonus budget" +
	 * "for the year and figureout who will be promoted"); Project pro3 = new
	 * Project("Office Reconstruction", "INPROGRESS",
	 * "The office building in Monroe has " +
	 * "been damaged due to hurricane in the region. This needs to be reconstructed"
	 * ); Project pro4 = new Project("Improve Intranet Security", "INPROGRESS",
	 * "With the recent data hack, the office" +
	 * "security needs to be improved and proper security team needs to be hired for "
	 * + "implementation");
	 * 
	 * 
	 * 
	 * // need to set both sides of the relationship manually using a convenience
	 * method
	 * 
	 * pro1.addEmployee(emp1); pro1.addEmployee(emp2); pro2.addEmployee(emp3);
	 * pro3.addEmployee(emp1); pro4.addEmployee(emp1); pro4.addEmployee(emp3);
	 * 
	 * 
	 * // need to set both sides of the relationship manually and bypass the
	 * convenience methods
	 * 
	 * emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
	 * emp2.setProjects(Arrays.asList(pro1)); emp3.setProjects(Arrays.asList(pro2,
	 * pro4));
	 * 
	 * // save employees in database
	 * 
	 * empRepo.save(emp1); empRepo.save(emp2); empRepo.save(emp3);
	 * empRepo.save(emp4); empRepo.save(emp5); empRepo.save(emp6);
	 * empRepo.save(emp7); empRepo.save(emp8); empRepo.save(emp9);
	 * 
	 * 
	 * // save projects in database
	 * 
	 * proRepo.save(pro1); proRepo.save(pro2); proRepo.save(pro3);
	 * proRepo.save(pro4);
	 * 
	 * }; }
	 */
}
