package com.jcs.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jcs.pma.springbean.Car;
import com.jcs.pma.springbean.Doors;
import com.jcs.pma.springbean.Engine;
import com.jcs.pma.springbean.Tires;

/*
 * This class is used to setup Spring and config
 * your Beans and separate the bean config from the main class
*/

@Configuration
public class SpringConfig {

//Define your own Beans in this class
	
	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		return new Car(e, d, t);
	}
}
