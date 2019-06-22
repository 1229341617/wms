package com._520it.wms.test;

import org.junit.Test;

import com.alibaba.druid.filter.config.ConfigTools;

public class DruidEncodeTest {
	@Test
	public void testName() throws Exception {
		String pwd = ConfigTools.encrypt("1229341617lq");
		System.out.println(pwd);
	}
}
