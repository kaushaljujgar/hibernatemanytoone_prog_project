package com.jspiders.hibernatemanytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Employee {
@Id
	private int id;
	private String name;
	private String email;
	private double salary;
	
	@ManyToOne
	private Company company;
	
}
