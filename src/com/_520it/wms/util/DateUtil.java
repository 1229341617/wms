package com._520it.wms.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getBeginTime(Date current) {
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
		return  c.getTime();
	}
	
	public static Date getEndTime(Date current) {
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
		c.add(Calendar.DATE, 1);
		c.add(Calendar.SECOND, -1);
		return  c.getTime();
	}
}
