package com._520it.wms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.wms.domain.Employee;
import com._520it.wms.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EhCacheTest {
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testGet() throws Exception {
		Employee e1 = employeeService.get(1L);
		Employee e2 = employeeService.get(1L);
		
		
	}
	
	

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
