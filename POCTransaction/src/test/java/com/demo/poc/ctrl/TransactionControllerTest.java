package com.demo.poc.ctrl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import com.demo.poc.POCTransactionApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = POCTransactionApplication.class)
@SpringBootTest
public class TransactionControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
		
	// Test to validate the Transaction using TransactionId.
	
	@Test
	public void verifyGetTransaction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/masterCard/transaction/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.txn_id").exists())
		.andExpect(jsonPath("$.txn_id").value(1L))
		.andExpect(jsonPath("$.device_type").value("Credit"))
		.andExpect(jsonPath("$.txn_date").value("2018-09-17T18:30:00.000+0000"))
		.andExpect(jsonPath("$.device_number").value(14))
		.andDo(print());
	} 
	
	// Test to validate ALL the Transactions.
	
	@Test
	public void testGetAllTransaction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/masterCard/transactions").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	
	// Test to validate the Transaction using Invalid TransactionId.
	
	@Test
	public void verifyInvalidTransactionId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/masterCard/transaction/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.errorMessage").value("Entered Transaction Number is not Available"))
		.andDo(print());
	}
	

}
