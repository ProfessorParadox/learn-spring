package com.learn_spring.springcore;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
	
	Tyre tyre;
		
	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public void drive() {
		System.out.println("bike bhaag rahi hai, " + tyre);
	}

}
