package com.transaction.demo.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionDetails implements Serializable{

	private static final long serialVersionUID = -8658798312716361398L;
	public TransactionDetails() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long txn_id;	
	private Integer device_number;
	private Integer txn_amount;
	private String device_type;
	private Date txn_date;
	 
	 public TransactionDetails(Long txn_id, Integer device_number, Integer txn_amount, String device_type,
				Date txn_date) {
			super();
			this.txn_id = txn_id;
			this.device_number = device_number;
			this.txn_amount = txn_amount;
			this.device_type = device_type;
			this.txn_date = txn_date;
		}
	 
	public Long getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(Long txn_id) {
		this.txn_id = txn_id;
	}

	public Integer getDevice_number() {
		return device_number;
	}

	public void setDevice_number(Integer device_number) {
		this.device_number = device_number;
	}

	public Integer getTxn_amount() {
		return txn_amount;
	}

	public void setTxn_amount(Integer txn_amount) {
		this.txn_amount = txn_amount;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public Date getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(Date txn_date) {
		this.txn_date = txn_date;
	}
	
} 