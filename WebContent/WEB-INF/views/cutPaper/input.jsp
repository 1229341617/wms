<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>试题信息编辑</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/commonAll.js"></script>
<script type="text/javascript" src="js/plugins/jquery-validate/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/plugins/fancyBox/jquery.fancybox.css"/>
<script type="text/javascript" src="js/plugins/fancyBox/jquery.fancybox.pack.js"></script>
<script type="text/javascript">
	$(".fancybox").fancybox();
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form name="editForm" action="cutPaper_saveOrUpdate" method="post" id="editForm" enctype="multipart/form-data">
		<s:hidden name="cutPaper.id" />
		<div id="container">
			<div id="nav_links">
				<span style="color: #1A5CC6;">试题编辑</span>
				<div id="page_close">
					<a>
						<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
					</a>
				</div>
			</div>
			<div class="ui_content">
				<table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
						<tr>
							<td class="ui_text_rt" width="140">试题总分</td>
							<td class="ui_text_lt">
								<s:textfield readonly="true" name="cutPaper.totalscore" cssClass="ui_input_txt02" />
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">科目名称</td>
							<td class="ui_text_lt">
								<s:textfield readonly="true" name="cutPaper.complepaper.subject.name" cssClass="ui_input_txt02" />
							</td>
						</tr>
						<s:if test="cutPaper.imagePath1 != null">
							<tr>
								<td class="ui_text_rt" width="140">试题图片1</td>
								<td class="ui_text_lt">
									<a class="fancybox" data-fancybox-group="gallary" href="<s:property value="cutPaper.imagePath1"/>">
										<img src="<s:property value="cutPaper.smallImagePath1"/>" class="list_img">
									</a>
								</td>
							</tr>
						</s:if>
						<s:if test="cutPaper.imagePath2 != null">
							<tr>
								<td class="ui_text_rt" width="140">试题图片2</td>
								<td class="ui_text_lt">
									<a class="fancybox" data-fancybox-group="gallary" href="<s:property value="cutPaper.imagePath2"/>">
										<img src="<s:property value="cutPaper.smallImagePath2"/>" class="list_img">
									</a>
								</td>
							</tr>
						</s:if>
						<tr>
							<td class="ui_text_rt" width="140">试题总得分</td>
							<td class="ui_text_lt">
								<s:hidden name="qo.parentId"/>
								<s:textfield name="cutPaper.score" cssClass="ui_input_txt02" />
							</td>
						</tr>
					<tr>
						<td>&nbsp;</td>
						<td class="ui_text_lt">
							&nbsp;<input type="submit" value="提交阅卷" class="ui_input_btn01 submit"/>
							&nbsp;<input id="cancelbutton" type="button" value="返回" class="ui_input_btn01"  onclick="javascript:history.back(-1);"/>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
</html>