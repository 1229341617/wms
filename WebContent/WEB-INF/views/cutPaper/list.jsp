<%@ page language="java" contentType="text/html; charset=UTF-8"
					pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/commonAll.js"></script>
<title>试题列表</title>
<style>
	.alt td{ background:black !important;}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form namespace="/" id="searchForm" action="cutPaper" method="post">
		<div id="container">
			<div class="ui_content">
				当前位置：&emsp;
				<s:a namespace="/" action="cutPaper">科目选择</s:a>
				<s:iterator value="#cutpapervos">
					-->
					<s:a namespace="/" action="cutPaper">
						<s:param name="qo.parentId" value="id"/>  
						<s:property value="name"/>
					</s:a>  
				</s:iterator>
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th style="width:30%">编号</th>
							<th style="width:30%">科目</th>
							<th style="width:20%">题号</th>
							<th style="width:20%"></th>
						</tr>
						<tbody>
						<s:iterator value="#pageResult.result">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="complepaper.subject.name"/></td>
								<td>
									<s:if test="parent == null">
										无
									</s:if>
									<s:else>
										<s:property value="titlenum.titlenum"/>
									</s:else>
								</td>
								<td>
									<s:url var="delete" namespace="/" action="cutPaper_delete">
										<s:param name="cutPaper.id" value="id"/>
									</s:url>
									<c:if test="${parent != null}">
										<c:if test="${isfinished}">
											<font color="red">已阅</font>
										</c:if>
										<c:if test="${!isfinished}">
												<s:a namespace="/" action="cutPaper_input">
													开始阅卷<s:param name="cutPaper.id" value="id"/>
													<s:param name="qo.parentId" value="qo.parentId"/>
												</s:a>
										</c:if>
									</c:if>
									<c:if test="${parent == null}">
										<s:a namespace="/" action="cutPaper">
											<s:param name="qo.parentId" value="id"/>
											<span style="color:green">进入科目</span>
										</s:a>
									</c:if>
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

