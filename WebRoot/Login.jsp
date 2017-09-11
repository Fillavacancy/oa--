<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  <script src="js/jquery1.8.3.js" type="text/javascript"></script>
  <script src="js/Login.js"    type="text/javascript"></script>
  <link href="css/Login.css" type="text/css" rel="stylesheet"> 
  <script type="text/javascript">
		$(function() {
			$("#submit").click(function() {
				var ddlLoginType = $("#ddlLoginType").val();
				var txt_UserName = $("#txt_UserName").val();
				var txt_UserPwd = $("#txt_UserPwd").val();
				var txt_ValidCode = $("#txt_ValidCode").val();
				if(ddlLoginType != "" && txt_UserName != "" && txt_UserPwd != "" && txt_ValidCode != "")
				{
					if(ddlLoginType == "编号"){
						var name = Number(txt_UserName);
						if(isNaN(name))
						{
				            alert("请输入数字！");
				            return false;
						}
					}
					var url = "${pageContext.request.contextPath}/LoginServlet";
					var args = {"ddlLoginType":ddlLoginType,"txt_UserName":txt_UserName,"txt_UserPwd":txt_UserPwd,
							   "txt_ValidCode":txt_ValidCode,"time":new Date()};
					$.post(url,args,function(data){
						if(data == "登录成功!")
						{
							window.open("homepage.jsp","_self");
						}
						else
							alert(data);
						//$("#message").html(data);
					});
				}
			});
		});
		$(function(){
			$("#next,#nextCode").click(function() {
				var url = "${pageContext.request.contextPath}/ObtainCodeServlet";
				var args = {"time":new Date()};
				$.post(url,args,function(data){
					$("#nextCode").val(data);
				});
			});
		});
		$(document).ready(function(){ 
			var url = "${pageContext.request.contextPath}/ObtainCodeServlet?type=1";
			var args = {"time":new Date()};
			$.post(url,args);
		}); 
  </script>
  </head>
  
  <body style="background:url('images/Loginss.png') no-repeat; height: 600px;")>
  		<div >
  			<span id="Logo"><img src="images/Logo.png"/></span>
  			<form action="LoginServlet" method="post">
	  			<div id="Login_Move">
	  				<table border="0" cellpadding="0" align="center">
	  				<tr>
	  					<td colspan="2" align="right" class="Typeface" id="interval">登录方式：</td>
	  					<td id="interval">
	  						<select name="ddlLoginType" id="ddlLoginType" style="width: 172px;" onchange="onchanges();">
	  							<option  value="编号">编号</option>
	  							<option  value="用户名">用户名</option>
	  						</select>
	  					</td>		
	  				</tr>
	  				<tr>
	  					<td align="right" class="Typeface" id="interval"><label id="lblLogTip">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>：</td>
	  					<td id="interval"><input name="txt_UserName" type="text" maxlength="20" id="txt_UserName"/></td>
	  				</tr>
	  				<tr>
	  					<td align="right" class="Typeface" id="interval">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	  					<td align="left" id="interval"><input name="txt_UserPwd" type="password" maxlength="20" id="txt_UserPwd" /></td>
	  				</tr>
	  				<tr>
	  					<td align="right" class="Typeface" id="interval">验&nbsp;证&nbsp;码：</td>
	  					<td id="interval"><input name="txt_ValidCode" type="text" id="txt_ValidCode" maxlength="10" /></td>
	  					<td ><input type="text" id="nextCode" value="${sessionScope.codes }" name="code" onclick="onloadss();" style="width: 55px; font-style: italic;letter-spacing:3px;" readonly="readonly"/></td>
	  					<td ><a href="#" style="margin:0px 0px 0px 4px;"  id="next">换一张?</a></td>
	  				</tr>
	  				<tr>
	                    <td align="left" >
	                       <span style="margin: 0px 0px 0px 90px; color: #999999;font-size: 12px;">
	                       <span id="lblallnum">这里都是数字0，没有字母o，也不区分大小写</span>
	                       </span>
	                     </td>
	                </tr>
	                <tr>
	                	<td><a href="Unchain.jsp"  id="Unlock">解锁?</a>&nbsp;<a href="RetrPassword.jsp" id="Unlock_1">忘记密码?</a></td>
	                </tr>
	  			</table>
	  			<span class="btu_Login">
	  				 <a href="#" id="submit"><img src="images/Btu_Login.png" id="btu_Login"/></a>
	  			</span>
	  			</div> 
  			</form>		
  		</div>
  </body>
</html>
