<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <script src="js/jquery1.8.3.js" type="text/javascript"></script>
  <link href="css/RetrPassword.css" type="text/css" rel="stylesheet"> 
  <script type="text/javascript">
  	function SendMail()
  	{
		 var url = "${pageContext.request.contextPath}/SendMailServlet";
		 var mail = document.getElementById("txt_Dealernumber").value;
		 if(mail != "")
		 {
			 var args = {"mail":mail,"time":new Date()};
			 $.post(url,args,function(data){
				alert(data);	 
			});
		 }
  	};
  	$(function() {
		$("#submit").click(function() {
			var userMail = $("#txt_Dealernumber").val();
			var code = $("#txt_Mobilephone").val();
			var pwd = $("#password").val();
			if(userMail != "" && code != "" && pwd != "")
			{
				var url = "${pageContext.request.contextPath}/ResetPasswordServlet";
				var args = {"userMail":userMail,"code":code,"pwd":pwd,"time":new Date()};
				$.post(url,args,function(data){
					alert(data);
					if(data == "恭喜、重置密码成功！")
					{
						window.open("ObtainCodeServlet?type=1","_self");
					}
					//$("#message").html(data);
				});
			}
		});
	});
  	function CheckMail() {
  		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
  		var mail = document.getElementById("txt_Dealernumber").value;
  		if (!reg.test(mail)) {
  			alert("邮箱格式不对");
  			return false;
  		} else
  		{
  	  		//邮箱格式输入正确、调用发送邮件函数
  			this.SendMail();
  		}
  	}
  </script>
  <title>卓越办公系统</title>
  </head>
  
  <body style="background:url('images/RetrievePassword.png') no-repeat; height: 600px;">
  		<div>
  			<span id="Logo"><img src="images/Logo.png"/></span>
  			<div id="RetrPassword_Move">
  				<table border="0" cellpadding="3" align="center">
  				<tr>
  					<td align="right" class="Typeface" id="interval">用户邮箱：</td>
  					<td id="interval"><input name="txt_Dealernumber" type="text" maxlength="20" id="txt_Dealernumber"/></td>
  					<td id="interval"><a href="#" class="Gain" onclick="CheckMail();">获取验证码</a></td>
  				</tr>
  				<tr>
  					<td align="right" class="Typeface" id="interval">验&nbsp;证&nbsp;码：</td>
  					<td id="interval"><input name="txt_Mobilephone" type="text" maxlength="20" id="txt_Mobilephone"/></td>
  					<td class="Hint" id="interval">验证码15分钟有效</td>
  				</tr>
  				<tr>  				
  					<td class="Typeface" id="interval" align="right">重置密码：</td>
  					<td id="interval"><input type="password" name="resetPwd" value="" id="password"/></td>
  				</tr>
  				<tr>
  					<td align="left" ><span id="lblallnum">重置后的密码没有字母O，只有数字0；没有字母L，只有数字1</span></td>
  				</tr>
  			</table>  
  			</div>  	
  			<span id="btu_restpwd">
  				<a href="#"  id="submit"><img alt="" src="images/Restpassword.png"></a>
  			</span>
  			<span id="btu_secede">
  				<a href="Login.jsp" ><img src="images/Secede.png" id="btu_Secede"/></a>
  			</span>
  		</div>
  </body>
</html>
