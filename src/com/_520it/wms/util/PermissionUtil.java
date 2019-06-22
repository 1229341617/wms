package com._520it.wms.util;

import java.lang.reflect.Method;

public class PermissionUtil {

	public static String buidPermission(Method method) {
		String name = method.getName();
		String className = method.getDeclaringClass().getName();
		return className + ":" + name;
	}
	
}
