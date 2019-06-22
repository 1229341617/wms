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
<title>系统菜单列表</title>
<style>
	.alt td{ background:black !important;}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form namespace="/" id="searchForm" action="systemMenu" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_bottom">
							<s:url var="url" namespace="/" action="systemMenu_input">
								<s:param name="qo.parentId" value="qo.parentId"/>
							</s:url>
							<input type="button" value="新增" class="ui_input_btn01 btn_redirect" data-url="<s:property value="#url"/>"/> 
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				当前位置：&emsp;
				<s:a namespace="/" action="systemMenu">根菜单</s:a>
				<s:iterator value="#menus">
					-->
					<s:a namespace="/" action="systemMenu">
						<s:param name="qo.parentId" value="id"/>  
						<s:property value="name"/>
					</s:a>  
				</s:iterator>
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>菜单编码</th>
							<th>菜单名称</th>
							<th>上级菜单</th>
							<th>URL</th>
							<th></th>
						</tr>
						<tbody>
						<s:iterator value="#pageResult.result">
							<tr>
								<td><s:property value="sn"/></td>
								<td><s:property value="name"/></td>
								<td><s:property value="parentName"/></td>
								<td><s:property value="url"/></td> 
								<td>
									<s:a namespace="/" action="systemMenu_input">
										编辑<s:param name="systemMenu.id" value="id"/>
										<s:param name="qo.parentId" value="qo.parentId"/>
									</s:a>
									<s:url var="empDelete" namespace="/" action="systemMenu_delete">
										<s:param name="systemMenu.id" value="id"/>
									</s:url>
									<a href="javascript:;" class="btn_delete" data-url="<s:property value="empDelete"/>">删除</a>
									
									<s:a namespace="/" action="systemMenu">
										<s:param name="qo.parentId" value="id"/>查看子菜单
									</s:a>
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

