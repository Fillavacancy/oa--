<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  <title>卓越办公系统</title>
  <script type="text/javascript" src="js/Officemail.js"></script>
  <link href="css/Officemail.css" type="text/css" rel="stylesheet"> 
  </head>
  
  <body>
  <div style="width: 100%;height: 100%;">
	<div style="border: solid 1px #ddd; height: 35px; width: 230px;  position: absolute; top: 10px; left: 186px; background-color: #F1E4F1;"></div>
  	<div id="side" style="margin-top: 47px;" >
  		<div class="subnav" >
  			<div class="Daily">  				
  				<span style="color: #333; font-family: 微软雅黑 ; font-weight: bold; font-size: 14px;">办公邮件</span>
  				<hr style="width: 230px;height:1px;border: 1px;background-color:#E0DEDE;color:#E0DEDE;margin-top: 9px;"/>
  			</div>
  				<table width="230px;" >
  					<tr>
  						<td id="Newmail" onclick="changeNewmail()"><a href="#">>>&nbsp;新邮件</a></td>
  					</tr>
  					<tr>
  						<td id="Readmail" onclick="changeReadmail()"><a href="#">>>&nbsp;收件箱</a></td>
  					</tr>
  					<tr>
  						<td><a href="#">>>&nbsp;发件箱</a></td>
  					</tr>
  					<tr>
  						<td id=Outboxanddrafts" onclick="Outboxanddraftss()"><a href="SelOutboxanddraftsServlet">>>&nbsp;草稿箱</a></td>
  					</tr>
  					<tr>
  						<td><a href="#">>>&nbsp;垃圾箱</a></td>
  					</tr>
  					<tr>
  						<td id="personalbook" onclick="personalbook()"><a href="#">>>&nbsp;私人通讯录</a></td>
  					</tr>
  					<tr>
  						<td id="peizhi" onclick="changePeizhi();"><a href="#">>>&nbsp;配置</a></td>
  					</tr>
  					<tr>
  						<td><a href="#">>>&nbsp;个人办公</a></td>
  					</tr>
  				</table>
  		</div>
  		<div  style="width: 800px; position: absolute; top: 0px; left: 450px;">
	  	<iframe id="changemail"  src="Newmail.jsp" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>  	
	  	</div>
  		<div id="Shift" style="width: 0px;">
  			<div id="Touch">
	  			<div class="Daily_">
	  				<span style="color: #333; font-family: 宋体 ; font-weight: bold; font-size: 18px;">联系我们</span>
	  				<hr style="width: 230px;height:1px;border: 1px;background-color:#E0DEDE;color:#E0DEDE;margin-top: 9px;"/>
	  			</div>
  				<p><span>公司：成都卓越信信息技术有限公司</span></p>
  				<p><span>地址：成都市武新花园1小区后门边边9-2-</span></p>
  				<p><span>702室</span></p>
  				<p><span>电话：15298122809</span></p>
  				<p><span>传真：028-85513219</span></p>
  			</div>
  		</div>
  		
  	</div>
  </div>
  </body>
</html>
