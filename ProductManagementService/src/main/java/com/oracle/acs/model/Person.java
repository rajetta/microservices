package com.oracle.acs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    @Column
	private String firstName;
    @Column
	private String lastName;
    @Column
    private Integer age;
    @Column
    private String favColor;
    
    
    public Person() {
    	super();
    }
    
    public Person(String firstName, String lastName, Integer age, String favColor) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    	this.favColor = favColor;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFavColor() {
		return favColor;
	}

	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}
	

}
