package com._520it.generator;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import com._520it.wms.domain.BaseDomain;
import com._520it.wms.util.ClassZhName;


public class ClassInfo {
	private String basePkg;//基础包的名称
	private String className;//类的简单名称
	private String objectName;//对象的名称,和类的简单名称相比，首字母小写
	private String zhName = "暂无中文类名";
	private List<String> props = new ArrayList<>();//类中的属性名称集合
	
	
	public ClassInfo(Class<?> clazz) {
		try {
			basePkg = clazz.getPackage().getName().substring(0, clazz.getPackage().getName().lastIndexOf("."));
			className = clazz.getSimpleName();
			objectName = className.substring(0, 1).toLowerCase() + className.substring(1,className.length());
			if(clazz.isAnnotationPresent(ClassZhName.class)){
				ClassZhName cznAnnotation = clazz.getAnnotation(ClassZhName.class);
				zhName = cznAnnotation.value();
			}
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, BaseDomain.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				props.add(pd.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getProps() {
		return props;
	}
	public void setProps(List<String> props) {
		this.props = props;
	}
	public String getZhName() {
		return zhName;
	}
	public void setZhName(String zhName) {
		this.zhName = zhName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getBasePkg() {
		return basePkg;
	}
	public void setBasePkg(String basePkg) {
		this.basePkg = basePkg;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
