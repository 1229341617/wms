<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>试卷信息编辑</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/commonAll.js"></script>
<script type="text/javascript" src="js/plugins/jquery-validate/jquery.validate.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form name="editForm" action="complePaper_saveOrUpdate" method="post" id="editForm" enctype="multipart/form-data">
		<s:hidden name="complePaper.id" />
		<div id="container">
			<div id="nav_links">
				<span style="color: #1A5CC6;">试卷编辑</span>
				<div id="page_close">
					<a>
						<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
					</a>
				</div>
			</div>
			<div class="ui_content">
				<table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
						<tr>
							<td class="ui_text_rt" width="140">考试</td>
							<td class="ui_text_lt">
								<s:select name="complePaper.exam.id" list="#exams" listKey="id" listValue="name" cssClass="ui_select03"/>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">试卷图片</td>
							<td class="ui_text_lt">
								<s:file name="pic" cssClass="ui_file"/>
								<s:if test="complePaper.imagePath != null">
									<img src="<s:property value="complePaper.imagePath"/>" class="list_img">
								</s:if>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">科目</td>
							<td class="ui_text_lt">
								<s:select name="complePaper.subject.id" list="#subjects" listKey="id" listValue="name" cssClass="ui_select03"/>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">学生</td>
							<td class="ui_text_lt">
								<s:select name="complePaper.student.id" list="#emps" listKey="id" listValue="name" cssClass="ui_select03"/>
							</td>
						</tr>
					<tr>
						<td>&nbsp;</td>
						<td class="ui_text_lt">
							&nbsp;<input type="submit" value="确定保存" class="ui_input_btn01 submit"/>
							&nbsp;<input id="cancelbutton" type="button" value="返回" class="ui_input_btn01" onclick="javascript:history.back(-1);"/>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
</html>