<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  <link href="css/Forwarding.css" type="text/css" rel="stylesheet"> 
  </head>
  
  <body>
  	<div id="a_head">
  		<div id="theof">
  			<table width="737px;">
  				<tr>
  					<th style="font-size: 18px;color: white; text-align: center;">自动转发</th>
  				</tr>
  			</table>
  		</div>
  		<div>
  			<table width="737px;"height="271px;">
  				<tr>
  					<td class="Fontchange">自动转发&nbsp;<input type="radio" name="btn"/>启动&nbsp;<input type="radio" name="btn" checked="checked"/>禁用</td>
  				</tr>
  				<tr>
  					<td class="Fontchange">缺省转发地址：<input type="text"/></td>
  				</tr> 
  				<tr>
  					<td class="Fontchange">当收到：<input type="text"/>&nbsp;发来的邮件时，自动转发至：<input type="text"/></td>
  				</tr> 				
  				<tr>
  					<td class="Fontchange" >不要自动转发从一下个人或群组发来的邮件：</td>
  				</tr>
  				<tr>
  					<td><textarea rows="2" cols="20"></textarea></td>
  				</tr>
  				<tr>
  					<td class="Fontchange">不要自动转发发给以下群组的邮件：</td>
  				</tr>
  				<tr>
  					<td><textarea rows="2" cols="20"></textarea></td>
  				</tr>
  			</table>
  			<div style=" width: 400px; line-height:30px; height:30px; text-align: center;" >
  				<a href="#"><input type="button" value="确定"/></a>
  				<a href="null.jsp"><input type="button" value="取消"/></a>
  			</div>
  		</div>
  	</div>  		
  </body>
</html>
