package com.au2020.Assignment.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;


@Entity
@Check(constraints = "balance >= 0")
public class Account {

	@Id
	@GeneratedValue
	private Integer accountid;
	
	private Double balance;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
	private User account_user;
	
	public Integer getaccountId() {
		return accountid;
	}

	public void setaccountId(Integer accountid) {
		this.accountid = accountid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public User getAccount_user() {
		return account_user;
	}

	public void setAccount_user(User account_user) {
		this.account_user = account_user;
	}
	
	
	public boolean withdraw(Double amount)
	{
		if(balance - amount  >= 0)
		{
			balance = balance - amount;
			return true;
		}
		return false;
	}
	
	
	public boolean deposit(Double amount)
	{
		if(amount <= 0)
			return false;
		balance += amount;
		return true;
		
	}
	


}
