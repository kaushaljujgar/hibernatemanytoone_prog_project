package com.jspiders.hibernatemanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytoone.dto.Company;
import com.jspiders.hibernatemanytoone.dto.Employee;

public class EmployeeCompany {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void  openConnection() {
		
		factory=Persistence.createEntityManagerFactory("ManyToOne");
		
		manager=factory.createEntityManager();
		
		transaction=manager.getTransaction();
		
	}
	
	private static void closeConnection() {
		
		if (factory !=null) {
			factory.close();
			
		}
		if (manager !=null) {
			manager.close();
			
		}
		if (transaction.isActive()) {
			transaction.rollback();
			
		}
	}
	public static void main(String[] args) {
		
		openConnection();
		
		transaction.begin();
		
		Company company1=new Company();
		company1.setId(3);
		company1.setName("Capgemini");
		company1.setCity("Pune");
		
		manager.persist(company1);
		
		Employee employee4=new Employee();
		employee4.setId(4);
		employee4.setName("Akshay");
		employee4.setEmail("akshay@gmail.com");
		employee4.setSalary(30000L);
		employee4.setCompany(company1);
		
		manager.persist(employee4);
		
		Employee employee5=new Employee();
		employee5.setId(5);
		employee5.setName("pratik");
		employee5.setEmail("pratik@gmail.com");
		employee5.setSalary(30000L);
		employee5.setCompany(company1);
		manager.persist(employee5);
		
		Employee employee6=new Employee();
		employee6.setId(6);
		employee6.setName("ram");
		employee6.setEmail("ram@gmail.com");
		employee6.setSalary(30000L);
		employee6.setCompany(company1);
		
		manager.persist(employee6);
		
		transaction.commit();
		
		closeConnection();
		
		
	}
	

}
