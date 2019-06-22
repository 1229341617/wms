package com._520it.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

import com._520it.wms.domain.CutPaper;
import com._520it.wms.domain.Distribution;
import com._520it.wms.domain.Exam;
import com._520it.wms.domain.Subject;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CodeGenerator {
	private static Configuration config;
	
	static{
		try {
			config = new Configuration();
			config.setDirectoryForTemplateLoading(new File("templates"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 步骤：
	 * 	1.创建配置对象:
	 * 		Configuration config = new Configuration();
	 * 	2.加载文件目录中的模板文件，并的到模板对象:
	 * 		config.setDirectoryForTemplateLoading(new File("templates"));
	 * 		Template template = config.getTemplate(templateFileName);									//templateFileName="DAO.java"
	 * 	3.得到文件的输出的相对路径:
	 * 		String outFilePath = MessageFormat.format(filePath,											//filepath="src/{0}/dao/{1}Dao.java";
	 * 												  classInfo.getBasePkg().replace(".","/"),
	 * 												  classInfo.getClassName(),
	 * 												  classInfo.getObjectName());
	 * 	4.判断文件相对输出路径是否含有目录，否则，创建目录:
	 * 		File outFile = new File(outFilePath);
	 * 		if(!outFile.getParentFile().exists()){
	 * 			outFile.getParentFile().mkdirs();
	 * 		}
	 * 	5.输出创建好的目录:
	 * 		template.process(classInfo, new FileWriter(new File(outFilePath));
	 * 
	 * 
	 * @param templateFileName	模板文件名称
	 * @param clazz				将创建模板的domain类的class
	 * @param filePath			模板文件创建后的文件输出路径
	 */
	private static void createTemplateFile(String templateFileName, Class<?> clazz, String filePath){
		try {
			Template template = config.getTemplate(templateFileName);
			ClassInfo classInfo = new ClassInfo(clazz);
			String outFilePath = MessageFormat.format(filePath, classInfo.getBasePkg().replace(".", "/"),classInfo.getClassName(),classInfo.getObjectName());
			File outFile = new File(outFilePath);
			if(!outFile.getParentFile().exists()){
				outFile.getParentFile().mkdirs();
			}
			template.process(classInfo, new FileWriter(new File(outFilePath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param templateFileName	模板文件名称
	 * @param clazz				将创建模板的domain类的class
	 * @param targetFilePath	字符串添加的目标xml文件路径
	 */
	private static void appendToXml(String templateFileName, Class<?> clazz, String targetFilePath){
		try {
			Template template = config.getTemplate(templateFileName);
			ClassInfo classInfo = new ClassInfo(clazz);
			StringWriter out = new StringWriter();
			template.process(classInfo, out);
			XmlUtil.appendToXml(new File(targetFilePath), out.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
//		create(Exam.class);
	}

	private static void create(Class<?> clazz) {
		createTemplateFile("DAO.java", clazz, "src/{0}/dao/{1}Dao.java");
		createTemplateFile("DAOImpl.java", clazz, "src/{0}/dao/impl/{1}DaoImpl.java");
		
		createTemplateFile("QueryObject.java", clazz, "src/{0}/query/{1}QueryObject.java");
		
		createTemplateFile("Service.java", clazz, "src/{0}/service/{1}Service.java");
		createTemplateFile("ServiceImpl.java", clazz, "src/{0}/service/impl/{1}ServiceImpl.java");
		
		createTemplateFile("Action.java", clazz, "src/{0}/web/action/{1}Action.java");
		
		createTemplateFile("list.jsp", clazz, "WebContent/WEB-INF/views/{2}/list.jsp");
		createTemplateFile("input.jsp", clazz, "WebContent/WEB-INF/views/{2}/input.jsp");
		
		createTemplateFile("hbm.xml", clazz, "resources/{0}/domain/{1}.hbm.xml");
		
		appendToXml("dao.xml", clazz, "resources/daoContext.xml");
		appendToXml("service.xml", clazz, "resources/serviceContext.xml");
		appendToXml("action.xml", clazz, "resources/actionContext.xml");
		System.out.println("生成完毕-------------------");
	}
	
	
}
