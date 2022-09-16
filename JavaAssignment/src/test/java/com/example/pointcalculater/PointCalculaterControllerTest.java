package com.example.pointcalculater;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.pointcalculater.model.Points;
import com.example.pointcalculater.service.PointServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointCalculaterControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Mock
	private PointServiceImpl pointsServices;

	@Mock
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	@Test
	public void testEmployee() throws Exception {
		pointsServices.getPointsByCustomerId(1l);
		mockMvc.perform(get("/calculate-points/customers/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.customerId").value("1"));

	}
	@Test 
	public void test_getPointsByCustomerId_success() throws Exception {
		Points	points=new Points (); 
		points.setCustomerId(1l);
		points.setLastMonthPoints(123); points.setLastSecondMonthPoints(0);
		points.setLastThirdMonthPoints(0); points.setTotalPoints(0);

		Mockito.when(pointsServices.getPointsByCustomerId(1l)).thenReturn(points);


		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/calculate-points/customers/1")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		int status =mvcResult.getResponse().getStatus();
		assertEquals(200, status); 		

	}
	@Test 
	public void test_getPointsByCustomerId() throws Exception {
		Points	points=new Points (); 
		points.setCustomerId(4l);
		points.setLastMonthPoints(123); points.setLastSecondMonthPoints(0);
		points.setLastThirdMonthPoints(0); points.setTotalPoints(0);

		Mockito.when(pointsServices.getPointsByCustomerId(5l)).thenReturn(points);


		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/calculate-points/customers/5")
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		String status =mvcResult.getResponse().getContentAsString();
		assertEquals("No Customer Found with this ID", status); 		

	}

}
