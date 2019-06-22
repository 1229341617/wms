package com._520it.wms.test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkDemo {
	public static void main(String[] args) throws Exception {
		//1.创建配置对象
		Configuration config = new Configuration();
		//2.设置模板加载目录
		config.setDirectoryForTemplateLoading(new File("templates"));
		//3.得到模板对象(指定模板文件)
		Template template = config.getTemplate("hello.html");
		//4.合并模板和数据
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("name", "Will");
		dataModel.put("age", 17);
		Writer out = new FileWriter(new File("test.html"));
		
		template.process(dataModel, out);
	}
}
