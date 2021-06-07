/**
 * 
 */
package com.jcs.pma.springbean;

/**
 * @author jcswa
 * Used for demonstration of creating a Bean for 
 * Spring Dependency Injection using Autowired
 *
 */
public class Car {

	private Engine e;
	private Doors d;
	private Tires t;
	
	public Car(Engine e, Doors d, Tires t) {
		super();
		this.e = e;
		this.d = d;
		this.t = t;
	}

	public Engine getE() {
		return e;
	}

	public void setE(Engine e) {
		this.e = e;
	}

	public Doors getD() {
		return d;
	}

	public void setD(Doors d) {
		this.d = d;
	}

	public Tires getT() {
		return t;
	}

	public void setT(Tires t) {
		this.t = t;
	}
	
	
	
}
