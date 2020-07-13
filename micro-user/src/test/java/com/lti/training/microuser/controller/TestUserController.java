package com.lti.training.microuser.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.training.microuser.dto.RegisterDto;
import com.lti.training.microuser.dto.UserDetailDto;
import com.lti.training.microuser.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)// internally managed object
public class TestUserController {
	
	// MVC Test
	// MVC calls need to be mocked
	@Autowired
	private MockMvc mockMvc; // help to generate a mock mvc call
	
	@MockBean
	private UserService service;
	
	@Test
	public void testRegister() throws Exception {
		// mock the register method of userService
		RegisterDto registerDto = new RegisterDto("test@mail.com", "1234567", "1234567", "First", "Last");
		UserDetailDto userDetailDto = new UserDetailDto("1","test@mail.com",  "First", "Last");
		when(service.register(registerDto)).thenReturn(userDetailDto);
		
		// build a request to our controller
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/register")
										// JSON format is required to be passed 
										.content(asJsonString(registerDto))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);
		// generate a request
		/*this.mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(content().json(asJsonString(userDetailDto)))*/
	 	MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		// assertEquals(asJsonString(userDetailDto), result.getResponse().getContentAsString());
	}
	
	
	// convert an object into JSON
	public static String asJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString= "";
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in JSON String conversion");
		}
		System.out.println("Json String : " + jsonString);
		return jsonString;
	}
	
}
