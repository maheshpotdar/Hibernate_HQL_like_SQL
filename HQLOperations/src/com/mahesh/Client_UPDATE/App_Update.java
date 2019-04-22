package com.mahesh.Client_UPDATE;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Update {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		// normal update/merge cha problem
		// 1. primary update karata yeta nahi.
		// 2. primary key sodun bakiche column compulsary update karayalacha pahije.
		// 3.manaje single column update karata yeta nahi.

		// HQL all update problem solved
		// 1.primary update karata yeto.
		// 2.single column update karu shakato.

		// primary key update.
		String hql = "UPDATE Employee SET id=100000 WHERE id=2";
		org.hibernate.query.Query<Employee> query = session.createQuery(hql);
		int hMRUp = query.executeUpdate();
		System.out.println("Primary key Update: " + hMRUp);

		System.out.println("update successfully.");

		// Single Coulmn Update
		String hql2 = "UPDATE Employee SET eaddress='Japan' WHERE id=1";
		org.hibernate.query.Query<Employee> query2 = session.createQuery(hql2);
		int HMUPRow = query2.executeUpdate();
		System.out.println("Single Row Update: " + HMUPRow);

		session.getTransaction().commit();
	}
}
