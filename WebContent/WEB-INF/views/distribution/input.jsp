<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>试题分配信息编辑</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/commonAll.js"></script>
<script type="text/javascript" src="js/plugins/jquery-validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/system/role.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form name="editForm" action="distribution_saveOrUpdate" method="post" id="editForm">
		<s:hidden name="distribution.id" />
		<div id="container">
			<div id="nav_links">
				<span style="color: #1A5CC6;">试题分配编辑</span>
				<div id="page_close">
					<a>
						<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
					</a>
				</div>
			</div>
			<div class="ui_content">
				<table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
						<tr>
							<td class="ui_text_rt" width="140">科目</td>
							<td class="ui_text_lt">
								<c:if test="${distribution.id != null}">
									<s:select name="distribution.subject.id" disabled="true" list="#subjects" listKey="id" listValue="name" cssClass="ui_select03"/>
								</c:if>
								<c:if test="${distribution.id == null}">
									<s:select name="distribution.subject.id" list="#subjects" listKey="id" listValue="name" cssClass="ui_select03"/>
								</c:if>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">老师</td>
							<td class="ui_text_lt">
								<s:select name="distribution.teacher.id" list="#teachers" listKey="id" listValue="name" cssClass="ui_select03"/>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">分配题号</td>
							<td class="ui_text_lt">
								<table>
									<tr>
										<td>
											<s:select name="" list="#titlenums" multiple="true" listKey="id" listValue="id" cssClass="ui_multiselect01 left"/>
										</td>
										<td align="center">
											<input type="button" id="select" value="-->" class="left2right"/><br/>
											<input type="button" id="selectAll" value="==>" class="left2right"/><br/>
											<input type="button" id="deselect" value="<--" class="left2right"/><br/>
											<input type="button" id="deselectAll" value="<==" class="left2right"/>
										</td>
										<td>
											<s:select name="distribution.titlenums.id" list="distribution.titlenums" multiple="true" listKey="id" listValue="id" cssClass="ui_multiselect01 right"/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					<tr>
						<td>&nbsp;</td>
						<td class="ui_text_lt">
							&nbsp;<input type="submit" value="确定保存" class="ui_input_btn01 submit"/>
							&nbsp;<input id="cancelbutton" type="button" value="返回" class="ui_input_btn01"  onclick="javascript:history.back(-1);"/>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
</html>