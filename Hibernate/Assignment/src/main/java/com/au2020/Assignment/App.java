package com.au2020.Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays; 

import com.au2020.Assignment.models.*;

public class App {
	public static void main(String[] args) {

		
		Bank bank = new Bank();
		
		//user 1
		User u1 = new User();
		u1.setName("Nitin");
		u1.setContact("23434");
		u1.setAddress("Ankleshwar");
		
		//account1
		Account a1 = new Account();
		a1.setBalance(new Double(100));
		a1.setAccount_user(u1);
		
		//user2
		User u2 = new User();
		u1.setName("Kathan");
		u1.setContact("313123");
		u1.setAddress("Ahmedabad");
		
		//account2
		Account a2 = new Account();
		a2.setBalance(new Double(500));
		a2.setAccount_user(u2);
		
		bank.addUser(u1);
		bank.addUser(u2);
		
		bank.addAccount(a1);
		bank.addAccount(a2);
		
		//successful transaction
		bank.sendMoney(a2, a1, new Double(100));
		
		//failed transaction - rollback
		bank.sendMoney(a1, a2, new Double(300));
		
		
		//JDBC - see all transactions
		System.out.println("--------------------");
		JDBC.displayTransaction(3);
		
		
	}
}
