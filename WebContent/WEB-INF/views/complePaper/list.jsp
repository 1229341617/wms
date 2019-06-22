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
<link rel="stylesheet" type="text/css" href="js/plugins/fancyBox/jquery.fancybox.css"/>
<script type="text/javascript" src="js/plugins/fancyBox/jquery.fancybox.pack.js"></script>
<title>试卷列表</title>
<style>
	.alt td{ background:black !important;}
</style>
<script type="text/javascript">
	$(".fancybox").fancybox();
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form namespace="/" id="searchForm" action="complePaper" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_bottom">
							<input type="button" value="切割试卷" class="ui_input_btn01 btn_batch_cutpapers" data-url="<s:url namespace="/" action="complePaper_batchCutPaper"/>"/> 
							<input type="button" value="新增" class="ui_input_btn01 btn_redirect" data-url="<s:url namespace="/" action="complePaper_input"/>"/> 
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="5%">选择</th>
							<th width="20%">考试名称</th>
							<th width="25%">试卷图片</th>
							<th width="10%">客观题总分</th>
							<th width="10%">学生姓名</th>
							<th width="10%">科目名称</th>
							<th width="10%">阅卷状态</th>
							<th width="10%"></th>
						</tr>
						<tbody>
						<s:iterator value="#pageResult.result">
							<tr>
								<td>
									<s:if test="iscutted == 1">
										<input disabled="disabled" type="checkbox" name="IDCheck" class="acb" data-eid="<s:property value="id"/>" />
									</s:if>
									<s:else>
										<input type="checkbox" name="IDCheck" class="acb" data-eid="<s:property value="id"/>" />
									</s:else>
								</td>
								<td><s:property value="exam.name"/></td>
								<td>
									<a class="fancybox" data-fancybox-group="gallary" href="<s:property value="imagePath"/>"  title="<s:property value="name"/>">
										<img src="<s:property value="smallImagePath"/>" class="list_img">
									</a>
								</td>
								<td><s:property value="objscore"/></td>
								<td><s:property value="student.simpleName"/></td>
								<td><s:property value="subject.name"/></td>
								<td>
									<s:if test="isreviewd == 1">
										<font color="red">已完成</font>
									</s:if>
									<s:else>
										<font color="green">未完成</font>
									</s:else>
								</td>
								<td>
									<s:url var="edit" namespace="/" action="complePaper_input">
										<s:param name="complePaper.id" value="id"/>
									</s:url>
									<s:url var="delete" namespace="/" action="complePaper_delete">
										<s:param name="complePaper.id" value="id"/>
									</s:url>
									
									<s:if test="iscutted == 1">
										<font color="red">已切割</font>
									</s:if>
									<s:else>
										<a href="<s:property value="edit"/>">编辑</a>
										<a href="javascript:;" class="btn_delete" data-url="<s:property value="delete"/>">删除</a>
									</s:else>
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

