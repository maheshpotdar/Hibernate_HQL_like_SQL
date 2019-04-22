package com.mahesh.Client_SELECT;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_SingleRowSelect {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee WHERE id=2";
		org.hibernate.Query<Employee> query = session.createQuery(hql);

		Employee employee = query.uniqueResult();

		System.out.println("Employee Info");
		System.out.println("ID: " + employee.getId());
		System.out.println("Name: " + employee.getEname());
		System.out.println("Address: " + employee.getAddress());

	}
}
