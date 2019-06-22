package ${basePkg}.web.action;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import ${basePkg}.domain.${className};
import ${basePkg}.query.${className}QueryObject;
import ${basePkg}.service.${className}Service;
import ${basePkg}.util.RequiredPermission;

public class ${className}Action extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private ${className}Service ${objectName}Service;
	private ${className} ${objectName} = new ${className}();
	private ${className}QueryObject qo = new ${className}QueryObject();

	@RequiredPermission("${zhName}列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", ${objectName}Service.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	
	@RequiredPermission("${zhName}编辑")
	public String input() throws Exception {
		if(${objectName}.getId() != null){
			${objectName} = ${objectName}Service.get(${objectName}.getId());
		}
		return INPUT;
	}
	
	@RequiredPermission("${zhName}保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(${objectName}.getId() != null){
				${objectName}Service.update(${objectName});
				addActionMessage("更新成功！");
			}else{
				${objectName}Service.save(${objectName});
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("${zhName}删除")
	public String delete() throws Exception {
		${objectName}Service.delete(${objectName}.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	
	
	public ${className}Service get${className}Service() {
		return ${objectName}Service;
	}

	public void set${className}Service(${className}Service ${objectName}Service) {
		this.${objectName}Service = ${objectName}Service;
	}
	public ${className} get${className}() {
		return ${objectName};
	}
	public void set${className}(${className} ${objectName}) {
		this.${objectName} = ${objectName};
	}
	public ${className}QueryObject getQo() {
		return qo;
	}
	public void setQo(${className}QueryObject qo) {
		this.qo = qo;
	}
}
