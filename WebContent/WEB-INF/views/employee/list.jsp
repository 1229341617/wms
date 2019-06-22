<%@ page language="java" contentType="text/html; charset=UTF-8"
					pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/commonAll.js"></script>
<script type="text/javascript" src="js/system/employee.js"></script>
<title>员工列表</title>
<style>
	.alt td{ background:black !important;}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form namespace="/" id="searchForm" action="employee" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							用户名/邮箱
							<s:textfield name="qo.keyword" cssClass="ui_input_txt02"/>
							专业
							<s:select name="qo.deptId" list="#depts" cssClass="ui-select03"
											 headerKey="-1" headerValue="所有专业"
											 listKey="id" listValue="name"/>
						</div>
						<div id="box_bottom">
							<input type="button" value="批量删除" class="ui_input_btn01 btn_batch_delete" data-url="<s:url namespace="/" action="employee_batchDelete"/>"/> 
							<input type="button" value="查询" class="ui_input_btn01 btn_page" data-page="1"/>
							<input type="button" value="新增" class="ui_input_btn01 btn_redirect" data-url="<s:url namespace="/" action="employee_input"/>"/> 
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" /></th>
							<th>编号</th>
							<th>用户名</th>
							<th>EMAIL</th>
							<th>年龄</th>
							<th>所属专业</th>
							<th>角色</th>
							<th></th>
						</tr>
						<tbody>
						<s:iterator value="#pageResult.result">
							<tr>
								<td><input type="checkbox" name="IDCheck" class="acb" data-eid="<s:property value="id"/>" /></td>
								<td><s:property value="id"/></td>
								<td><s:property value="name"/></td>
								<td><s:property value="email"/></td>
								<td><s:property value="age"/></td>
								<td><s:property value="dept.name"/></td>
								<td><s:property value="roleNames"/> </td>
								<td>
									<s:url var="empEdit" namespace="/" action="employee_input">
										<s:param name="employee.id" value="id"/>
									</s:url>
									<a href="<s:property value="empEdit"/>">编辑</a>
									<s:url var="empDelete" namespace="/" action="employee_delete">
										<s:param name="employee.id" value="id"/>
									</s:url>
									<a href="javascript:;" class="btn_delete" data-url="<s:property value="empDelete"/>">删除</a>
								</td>
							</tr>
							</s:iterator>
							
						</tbody>
					</table>
				</div>
				<%@include file="/WEB-INF/views/common/common_page.jsp" %>
			</div>
		</div>
	</s:form>
</body>
</html>

