package com._520it.wms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.wms.domain.Department;
import com._520it.wms.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentTest{
	@Autowired
	@Qualifier("departmentService")
	private DepartmentService departmentService;

	@Test
	public void testSave() {
		Department dept = new Department();
		dept.setName("����1");
		dept.setSn("001");
		departmentService.save(dept);
	}

	@Test
	public void testDelete() {
		Department dept = new Department();
		departmentService.delete(1L);
	}

	@Test
	public void testUpdate() {
		Department dept = new Department();
		dept.setId(1L);
		dept.setName("����");
		dept.setSn("NNN");
		departmentService.update(dept);
	}

	@Test
	public void testGet() {
		System.out.println(departmentService.get(1L));
		System.out.println(departmentService.get(1L));
	}

	@Test
	public void testList() {
		List<Department> depts = departmentService.findAll();
		for (Department d : depts) {
			System.out.println(d);
		}
	}

}
