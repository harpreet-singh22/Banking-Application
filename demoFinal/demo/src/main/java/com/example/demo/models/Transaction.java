package com.example.demo.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long transactionId;
	Double amount;
	Date txn_date;
	String type;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
	Accounts account;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(Date txn_date) {
		this.txn_date = txn_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

}
