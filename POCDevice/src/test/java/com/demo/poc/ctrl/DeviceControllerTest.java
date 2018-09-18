package com.demo.poc.ctrl;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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

import com.demo.poc.POCDeviceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=POCDeviceApplication.class)
@SpringBootTest
public class DeviceControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}
	
	@Test
	public void verifyGetDevice() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/masterCard/devices/17").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.deviceNumber").exists())
		.andExpect(jsonPath("$.deviceNumber").value(17))
		.andExpect(jsonPath("$.deviceType").value("debit"))
		.andExpect(jsonPath("$.expDate").value("2018-09-18T05:03:19.000+0000"))
		.andExpect(jsonPath("$.txnLimit").value(300))
		.andDo(print());
	}
	
	
	@Test
	public void verifyInvalidDeviceId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/masterCard/devices/189").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.errorCode").value(404))
			.andExpect(jsonPath("$.errorMessage").value("Entered Device Number is not Available"))
			.andDo(print());
	}
	
	@Test
	public void verifyAllToDoList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/masterCard/devices").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(7))).andDo(print());
	}
} 
