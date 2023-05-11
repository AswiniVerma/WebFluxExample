package com.aswini.WebFluxExample.Entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aswini.WebFluxExample.dto.EmployeeDto;

public class EmployeeTest {
	EmployeeDto employee = new EmployeeDto();
	
	@BeforeEach
	public void before() {
		EmployeeDto employee2  = new EmployeeDto("1","Aswini","24");
	}
	
	@AfterEach
	public void after() {
		employee = null;
	}
	
	@Test
	void testSetName() {
		employee.setName("Aswini");
		assertEquals("Aswini", employee.getName());
	}
	@Test
	void testSetAge() {
		employee.setAge("24");
		assertEquals("24", employee.getAge());
	}
}
