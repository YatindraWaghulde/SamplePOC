package com.demo.poc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.poc.model.TransactionDetails;
import com.demo.poc.repository.TransactionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepository txnRepository;
	
	@InjectMocks
	private TransactionService txnService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
		
	@Test
	public void testGetAllTransaction(){
		List<TransactionDetails> txnList = new ArrayList<TransactionDetails>();
		txnList.add(new TransactionDetails(1L, 1, 100, "VISA", new Date()));
		txnList.add(new TransactionDetails(2L, 1, 100, "VISA", new Date()));
		txnList.add(new TransactionDetails(3L, 1, 100, "VISA", new Date()));
		when(txnRepository.findAll()).thenReturn(txnList);
		
		List<TransactionDetails> result = txnService.getAllTransaction();
		assertEquals(3, result.size());
	}
	
	
	@Test
	public void testTransactionById(){
		TransactionDetails txn = new TransactionDetails(1L, 1, 100, "VISA", new Date());
		when(txnRepository.findById(1L)).thenReturn(Optional.of(txn));
		Optional<TransactionDetails> result = txnService.getTransaction(1L);
		
		if(result != null) {
			assertEquals("1L", result.get().getTxn_id());
			assertEquals("150", result.get().getTxn_amount());
			assertEquals("VISA", result.get().getDevice_type());
		}				
	}
	
	
	
	@Test
	public void testSaveTransaction(){
		TransactionDetails txn = new TransactionDetails(3L, 3, 300, "MESTRO", new Date());
		when(txnRepository.save(txn)).thenReturn(txn);
		TransactionDetails result = txnService.addTransaction(txn);
		assertEquals("3", result.getTxn_id().toString());
		assertEquals("300", result.getTxn_amount().toString());
		assertEquals("MESTRO", result.getDevice_type());
	}
	
	
} 
