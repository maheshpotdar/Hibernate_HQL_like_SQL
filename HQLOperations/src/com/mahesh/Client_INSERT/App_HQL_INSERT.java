package com.mahesh.Client_INSERT;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_HQL_INSERT {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(EmployeeInfo.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		// hql like sql we need to write query.
		// hql madhe insert,update,delete la executeUpdate use kara.

		// hql madhe select madhe
		// 2 part ahet.
		// 1-Row fetch(uniqueResult).
		// Multiple row fetch(list).

		String hql = "INSERT INTO EmployeeInfo(id,ename,address) SELECT  e.id,e.ename,e.address FROM Employee e";

		org.hibernate.query.Query<EmployeeInfo> query = session.createQuery(hql);
		int howmanyInserted = query.executeUpdate();
		System.out.println("howmanyInserted: " + howmanyInserted);
		session.getTransaction().commit();

		System.out.println("Inserted successfully.");
	}
}
