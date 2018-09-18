package com.demo.poc.model;

import java.util.List;
import java.util.Optional;

public interface TransactionInterface {

	public Optional<TransactionDetails> getTransaction(int transactionId);
	public List<TransactionDetails> getAllTransaction();
	public void addTransaction(TransactionDetails transaction);
	public void updateTransaction(TransactionDetails transaction);
	public void deleteTransaction(int transactionId);
	
}
