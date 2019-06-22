package com._520it.wms.test;

import org.junit.Test;

import com._520it.wms.util.MD5;

public class Md5Test {
	@Test
	public void testMd5() throws Exception {
		MD5 md5 = new MD5();
		md5.Init();
		md5.Update("1234");
		String result = md5.asHex();
		System.out.println("result:" + result);
	}
}
