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
public class Audit {

	@Id
	@GeneratedValue
	private Integer auditid;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "senderAccountId")
	private Account senderAccount;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "recieverAccountId")
	private Account recieverAccount;
	
	
	private Double amount;
	
	public Account getsenderAccount() {
		return senderAccount;
	}

	public void setsenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Account getrecieverAccount() {
		return recieverAccount;
	}

	public void setrecieverAccount(Account recieverAccount) {
		this.recieverAccount = recieverAccount;
	}

	
	public Integer getauditId() {
		return auditid;
	}

	public void setauditId(Integer auditid) {
		this.auditid = auditid;
	}



	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	
	
	
}
