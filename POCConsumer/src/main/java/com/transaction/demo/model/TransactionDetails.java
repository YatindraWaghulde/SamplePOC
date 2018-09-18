package com.transaction.demo.model;
import java.util.Date;

public class TransactionDetails {

	private Long txn_id;	
	private Integer device_number;
	private Integer txn_amount;
	private String device_type;
	private Date txn_date;
		 
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

	@Override
	public String toString() {
		return "TransactionDetails [txn_id=" + txn_id + ", device_number=" + device_number + ", txn_amount="
				+ txn_amount + ", device_type=" + device_type + ", txn_date=" + txn_date + "]";
	}
	
} 