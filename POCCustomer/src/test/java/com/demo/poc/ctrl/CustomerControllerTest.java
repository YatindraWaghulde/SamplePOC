package com.demo.poc.ctrl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.aspectj.lang.annotation.Before;
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
import static org.hamcrest.collection.IsCollectionWithSize.hasSize; 

import com.demo.poc.POCCustomerApplication;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = POCCustomerApplication.class, secure = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=POCCustomerApplication.class)
@SpringBootTest 
public class CustomerControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@org.junit.Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testGetCustomerById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/14").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.customerId").exists())
		.andExpect(jsonPath("$.firstName").exists())
		.andExpect(jsonPath("$.lastName").exists())
		.andExpect(jsonPath("$.customerId").value(14))
		.andExpect(jsonPath("$.firstName").value("string"))
		.andExpect(jsonPath("$.lastName").value("string"))
		.andDo(print());
	}
	
	@Test
	public void testInvalidGetCustomerById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/143").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andDo(print());
	}
	
	@Test
	public void testGetCustomers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(5))).andDo(print());
	}
	
//	@Test
//	public void testInvalidGetCustomers() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$").value(null))
//		.andDo(print());
//	}
	
	
	
	
}
