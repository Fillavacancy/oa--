<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Jsp Template</title>
		<script src="js/jquery1.8.3.js" type="text/javascript"></script>
		<link href="css/Personalbook.css" type="text/css" rel="stylesheet"> 
	</head>
	<body>
		<div>
			<div style="width:735px; border: solid 1px #ddd; margin-top:10px; background-color:#F1E4F1;font: 18px bold; color: white;" align="center">
			</div>
			<table class="dt_table">
	   			<tr>
	   				<th>选中</th>
	   				<th>收件人</th>
	   				<th>主题</th>
	   			</tr>
				<c:forEach var="info" items="${sessionScope.OutboxanddraftsC}">
				<tr>
					<td><input  type="checkbox" id="chec" value="${info.outdraId }"/></td>
					<td><a href="#">${info.outdraRecipients }</a></td>
					<td><a href="#">${info.outdraSubject }</a></td>
				</tr>
				</c:forEach>
   			</table>
		</div>
	</body>
</html>
