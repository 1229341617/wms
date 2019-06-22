<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>考试信息编辑</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/commonAll.js"></script>
<script type="text/javascript" src="js/plugins/jquery-validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(function () {
        $("input[name='exam.startdate']").addClass("Wdate").click(function () {
            WdatePicker({
            	dateFmt:'yyyy-MM-dd HH:mm:ss',
                maxDate: $("input[name='exam.startdate']").val()
            });
        });
        $("input[name='exam.enddate']").addClass("Wdate").click(function () {
            WdatePicker({
            	dateFmt:'yyyy-MM-dd HH:mm:ss',
                minDate:$("input[name='exam.startdate']").val(),
                maxDate: new Date()
            });
        });
    });
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/common_msg.jsp" %>
	<s:form name="editForm" action="exam_saveOrUpdate" method="post" id="editForm">
		<s:hidden name="exam.id" />
		<div id="container">
			<div id="nav_links">
				<span style="color: #1A5CC6;">考试编辑</span>
				<div id="page_close">
					<a>
						<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
					</a>
				</div>
			</div>
			<div class="ui_content">
				<table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
						<tr>
							<td class="ui_text_rt" width="140">名称</td>
							<td class="ui_text_lt">
								<s:textfield name="exam.name" cssClass="ui_input_txt02" />
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">时长/分钟</td>
							<td class="ui_text_lt">
								<s:textfield name="exam.totaltimes" cssClass="ui_input_txt02" />
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">科目</td>
							<td class="ui_text_lt">
								<s:select name="exam.subject.id" list="#subjects" listKey="id" listValue="name" cssClass="ui_select03"/>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">开始时间</td>
							<td class="ui_text_lt">
                        		<s:textfield name="exam.startdate" cssClass="ui_input_txt02"/>
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">结束时间</td>
							<td class="ui_text_lt">
                        		<s:textfield name="exam.enddate" cssClass="ui_input_txt02"/>
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