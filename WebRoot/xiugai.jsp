<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
      <title></title>
      <script src="js/jquery1.8.3.js" type="text/javascript"></script>
      <script type="text/javascript">
		$(function() {
			$("#submit").click(function() {
				var pwd1 = $("#pwd1").val();
				var pwd2 = $("#pwd2").val();
				if(pwd1 != "" && pwd2 != "")
				{
					if(pwd1 == pwd2)
					{
						var url = "${pageContext.request.contextPath}/ResetLoginPwdServlet";
						var args = {"pwd":pwd1,"time":new Date()};
						$.post(url,args,function(data){
							alert(data);
						});
					}
					else
						alert("输入的两次密码不一致!");
				}
				else
					alert("请输入完整!");
			});
		});
	</script>
  </head>
  <body>
   		<div> 
   		<table style="background-color: #F1E4F1; border-top: solid 2px #ddd;border-left: solid 2px #ddd;border-right: solid 2px #ddd;" width="737px;">
   			<tr>
   				<td style="font-size: 18px; color: white;" align="center">修改登陆密码</td>
         	</tr>
   		
   		 </table>
   		</div>
   		
   		<div>
   		 <table border="1px" width="737px" bordercolor="#dddddd" cellpadding="0px" cellspacing="0px" >
   		  <tr style="height: 32px">
   		   <td style="width: 105px; font-size: 12px;""><label>&nbsp;${sessionScope.user.userName }</label></td>
   		   <td style="height: 32px; font-size: 12px;" align="left">您好。请输入新口令。注意，口令中不能包含中文字符</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td style="font-size: 12px; text-align: right;">新口令:</td>
   		   <td><input type="password"   name="" id="pwd1" style="width: 368px;"></td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td style="font-size: 12px; text-align: right;">确认口令:</td>
   		   <td><input type="password"   name="" id="pwd2" style="width: 368px;"></td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td></td>
   		   <td align="center">
   		   		<input type="button" name="" id="submit" value="确认"/>&nbsp;  
   		   		<a href="null.jsp"><input type="button" id="" value="取消"/></a>
   		   </td>
   		  </tr>
   		  
   		 </table>
   		 </div>
   		
   		
  </body>
</html>
