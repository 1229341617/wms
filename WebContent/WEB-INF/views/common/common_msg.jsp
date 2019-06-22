<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript">
	var msg;
	<s:if test="hasActionErrors()">
		msg = '<s:property value="actionErrors[0]"/>';
		$.dialog({
			title:"提示",
			icon:"face-sad",
			content:msg,
			ok:true
		});
	</s:if>
	<s:if test="hasActionMessages()">
		msg = '<s:property value="actionMessages[0]"/>';
		$.dialog({
			title:"提示",
			icon:"face-smile",
			content:msg,
			ok:true
		});
	</s:if>
</script>
