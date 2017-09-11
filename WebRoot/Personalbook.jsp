<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Jsp Template</title>
		<script src="js/jquery1.8.3.js" type="text/javascript"></script>
		<link href="css/Personalbook.css" type="text/css" rel="stylesheet"> 
		<script type="text/javascript">
			$(document).ready(function(){ 
				var temp = ${message};
				alert(temp);
			}); 
		</script>
	</head>
	<body>
		<div>
			<div style="width:735px; border: solid 1px #ddd; margin-top:10px; background-color:#F1E4F1;font: 18px bold; color: white;" align="center">
				<label >私人通讯录</label>
			</div>
			<table class="dt_table">
	   			<tr>
	   				<th>姓名</th>
	   				<th>电话</th>
	   				<th>电子邮件</th>
	   				<th>新建日期</th>
	   				<th>编辑</th>
	   				<th>删除</th>
	   			</tr>
				<c:forEach var="personalbook" items="${sessionScope.Personalbook}">
				<tr>
					<td>${personalbook.perbookUsename}</td>
					<td>${personalbook.perbookPhone}</td>
					<td><a href="#">${personalbook.perbookMail}</a></td>
					<td>${personalbook.perbookDate}</td>
					<td><a href="${personalbook.perbookId}"><img alt="" src="images/bj.png"/></a></td>
					<td><a href="DlePersonalbookServlet?id=${personalbook.perbookId}"><img alt="" src="images/sc.png"/></a></td>
				</tr>
				</c:forEach>
   			</table>
   			<div id="btm_btn">
   				<input type="button" value="上一页"/>
   				<input type="button" value="下一页"/>
   				<input type="button" value="首页"/>
   				<input type="button" value="尾页"/>
   				<a href="huifu.jsp"><input type="button" value="新建"/></a>
   			</div>
		</div>
	</body>
</html>
