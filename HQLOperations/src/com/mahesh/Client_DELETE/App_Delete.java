package com.mahesh.Client_DELETE;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Delete {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(3);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		String hql = "DELETE FROM Employee WHERE id=3";
		org.hibernate.query.Query<Employee> query = session.createQuery(hql);
		int del = query.executeUpdate();
		System.out.println("Deleted successfully. " + del);
		session.getTransaction().commit();
	}
}
