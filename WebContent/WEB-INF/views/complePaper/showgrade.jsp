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
<title>成绩详情</title>
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
						<div id="box_top" style="text-align:center">成绩详情</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="50%">科目</th>
							<th width="50%">成绩</th>
						</tr>
						<tbody>
						<s:iterator value="#pageResult.result">
							<tr>
								<td><s:property value="subject.name"/></td>
								<td><s:property value="objscore"/></td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>

