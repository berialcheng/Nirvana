package com.nirvana.springmvc.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {
	private String firstName;
	private String lastName;
	
	public Person(){
		
	}
	
	public Person(String firstName,String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
