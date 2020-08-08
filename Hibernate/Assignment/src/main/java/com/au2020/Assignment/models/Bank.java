package com.au2020.Assignment.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Bank {
	
	Configuration config;
	SessionFactory sessionFactory;
	
	public Bank()
	{
		config = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(Account.class).addAnnotatedClass(Audit.class);

		
		sessionFactory = config.buildSessionFactory();

		
	}
	
	public void addUser(User ob)
	{	Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ob);

		session.getTransaction().commit();
		session.close();
	}
	
	public void addAccount(Account ob)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ob);

		session.getTransaction().commit();
		session.close();
	}
	
	public void sendMoney(Account sender, Account receiver, Double amount)
	{	
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		if(sender.withdraw(amount)){
			
			receiver.deposit(amount);
			
			Audit audit = new Audit();
			audit.setrecieverAccount(receiver);
			audit.setsenderAccount(sender);
			audit.setAmount(amount);
			session.saveOrUpdate(sender);
			session.saveOrUpdate(receiver);
			session.save(audit);
			session.getTransaction().commit();
		}	
		else
			session.getTransaction().rollback();
		
		session.close();
	}
}
