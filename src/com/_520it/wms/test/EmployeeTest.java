package com._520it.wms.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.wms.domain.Employee;
import com._520it.wms.query.EmployeeQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeTest{
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	@Test
	public void testSave() {
		Employee emp = new Employee();
		for (int index = 1; index <= 10; index++) {
			emp.setName("w_" + index);
			employeeService.save(emp);
		}
	}

	@Test
	public void testDelete() {
		Employee emp = new Employee();
		employeeService.delete(16L);
	}
	
	@Test
	public void testBatchDelete() {
		employeeService.batchDelete(Arrays.asList(22L,23L,24L));
	}

	@Test
	public void testUpdate() {
		Employee emp = employeeService.get(11L);
		emp.setAge(66);
		employeeService.update(emp);
	}

	@Test
	public void testGet() {
		System.out.println(employeeService.get(11L));
	}

	@Test
	public void testList() {
		List<Employee> emps = employeeService.findAll();
		for (Employee e : emps) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testQuery() {
		EmployeeQueryObject qo = new EmployeeQueryObject();
		List<Employee> query = employeeService.query(qo);
		for (Employee e : query) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testQuery1() {
		PageResult pageResult = employeeService.query(-1, 5);
		List<Employee> query = pageResult.getResult();
		for (Employee e : query) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testQuery2() {
		List<Employee> query = employeeService.queryForList(4, 2, null);
		for (Employee e : query) {
			System.out.println(e);
		}
	}

}
