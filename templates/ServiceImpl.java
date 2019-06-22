package ${basePkg}.service.impl;

import java.util.List;

import ${basePkg}.dao.${className}Dao;
import ${basePkg}.domain.${className};
import ${basePkg}.query.PageResult;
import ${basePkg}.query.${className}QueryObject;
import ${basePkg}.service.${className}Service;

public class ${className}ServiceImpl implements ${className}Service{
	private ${className}Dao ${objectName}Dao;

	@Override
	public void save(${className} obj) {
		${objectName}Dao.save(obj);
	}

	@Override
	public void delete(Long id) {
		${objectName}Dao.delete(id);
	}

	@Override
	public void update(${className} obj) {
		${objectName}Dao.update(obj);
	}

	@Override
	public ${className} get(Long id) {
		return ${objectName}Dao.get(id);
	}

	@Override
	public List<${className}> findAll() {
		return ${objectName}Dao.findAll();
	}

	@Override
	public PageResult advanceQuery(${className}QueryObject qo) {
		return ${objectName}Dao.advanceQuery(qo);
	}

	public ${className}Dao get${className}Dao() {
		return ${objectName}Dao;
	}

	public void set${className}Dao(${className}Dao ${objectName}Dao) {
		this.${objectName}Dao = ${objectName}Dao;
	}

}
