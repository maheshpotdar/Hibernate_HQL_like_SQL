package com.mahesh.Client_SELECT;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App_MultipleRowSelect {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT id,ename,address FROM Employee";

		Query<Object[]> query = session.createQuery(hql);

		List<Object[]> employees = query.list();
		for (Object[] obj : employees) {

			System.out.println("Multiple Select Operation start");
			System.out.println("ID: " + obj[0]);
			System.out.println("Name: " + obj[1]);
			System.out.println("Address: " + obj[2]);
		}

	}

}
