package ${basePkg}.service;

import java.util.List;

import ${basePkg}.domain.${className};
import ${basePkg}.query.PageResult;
import ${basePkg}.query.${className}QueryObject;

public interface ${className}Service {
	void save(${className} ${objectName});
	
	void delete(Long id);
	
	void update(${className} ${objectName});
	
	${className} get(Long id);
	
	List<${className}> findAll();
	
	PageResult advanceQuery(${className}QueryObject qo);
}
