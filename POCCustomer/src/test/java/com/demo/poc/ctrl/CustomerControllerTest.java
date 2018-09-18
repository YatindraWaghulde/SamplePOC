package com.mc.ovfc.ctrl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mc.ovfc.model.CustomerDetails;
import com.mc.ovfc.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class, secure = false)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	public CustomerService customerService;
	
	
	
	@Test
	public void getcustomers() {
		System.out.println("################################################");
		System.out.println("getcustomers() called");
		System.out.println("################################################");

		
	}
	
	
	
	
	
}
