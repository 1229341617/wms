<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传下载界面</title>
</head>
<body>
	<s:debug/>
	<s:fielderror fieldName="headImg"/>
	<s:form namespace="/" action="validate_upload" method="post" enctype="multipart/form-data">
		选择文件:<s:file name="headImg"/><br/>
		<s:submit value="上传" />
	</s:form>
</body>
</html>