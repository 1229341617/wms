package com._520it.wms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.wms.service.PermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PermissionTest{
	@Autowired
	@Qualifier("permissionService")
	private PermissionService permissionService;


	@Test
	public void testDelete() {
	}

	@Test
	public void testGet() {
	}

	@Test
	public void testList() {
	}
	
	@Test
	public void testReLoad() {
		permissionService.reload();
//		permissionService.reloadByWill();
	}

}
