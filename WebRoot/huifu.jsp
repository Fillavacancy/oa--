<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
      <title></title>
      <script src="js/jquery1.8.3.js" type="text/javascript"></script>
      <link href="css/btn.css" type="text/css" rel="stylesheet"/>
	  <script type="text/javascript">
	  	  var list = new Array();//定义一个用来装用户信息的集合
		  $(document).ready(function() {
				$.ajax( {
					type : "post",
					url : "${pageContext.request.contextPath}/SelUserAllServlet",
					cache : false,
					data : {"time" : new Date()},
					dataType : 'json',
					success : function(json) {
						$(json).each(function(){
	  	                    list.push(this);//依次将每个用户信息加入集合
							var selector = document.getElementById('Cryptoguard');
							var opp = new Option(this.userName,this.userId);
							opp.name = "option1";
							selector.add(opp);
							var phone = document.getElementById('phone');
							phone.value = list[0].userPhone;
							var mail = document.getElementById('mail');
							mail.value = list[0].userMail;
						});
					}
				}, "json");
			});
			function changeIndex()
			{
				var Cryptoguard = $("#Cryptoguard").val();
				for ( var i = 0; i < list.length; i++) {
				  if(list[i].userId == Cryptoguard)
					{
						var phone = document.getElementById('phone');
						phone.value = list[i].userPhone;
						var mail = document.getElementById('mail');
						mail.value = list[i].userMail;
					}
				}
			}
			$(function() {
				$("#submit").click(function() {
					var userid = $("#Cryptoguard").val();
					var name = $("#Cryptoguard").find("option:selected").text();
					var phone = $("#phone").val();
					var mail = $("#mail").val();
					if(userid != "" && name != "" && phone != "" && mail != "")
					{
						var url = "${pageContext.request.contextPath}/SavePersonalbookServlet";
						var args = {"userid":userid,"name":name,"phone":phone,
								   "mail":mail,"time":new Date()};
						$.post(url,args,function(data){
							if(data == "添加私人好友成功！")
							{
								window.open("SelPersonalbookServlet","_self");
							}
							else
								alert(data);
						});
					}
					else 
						alert("请输入完整！");
				});
			});
	  </script>
  </head>
  <body>
   		<div style=" text-align:center; background-color: #F1E4F1;font-size=32px;width: 737px;color: white;"> 
   		 联系人
   		</div>
   		<form action="">
	   		<div >
	   		 <table style="text-align:center; border:solid 1px #ddd; width:737px;" cellpadding="0px" cellspacing="0px">
	   		  <tr style="height: 32px">
	   		   <td style="text-align:right;">姓&nbsp;名：</td>
	   		   <td style="text-align:left;">
	   		   		<select id="Cryptoguard" style="width: 368px;" onchange="changeIndex()">
	   		   		</select>
	   		   </td>
	   		  </tr>
	   		  <tr style="height: 32px">
	   		   <td style="text-align:right;">联系电话：</td>
	   		   <td style="text-align:left;"><input type="text"  name="" id="phone" style="width: 368px;"></td>
	   		  </tr>
	   		  <tr style="height: 32px">
	   		   <td style="text-align:right;">电子邮箱：</td>
	   		   <td style="text-align:left;"><input type="text"  name="" id="mail" style="width: 368px;"></td>
	   		  </tr>
	   		  <tr style="height: 32px">
	   		   <td></td>
	   		   <td style="text-align:left;">
		   		   <input type="button" name="" id="submit" value="确认" />&nbsp;&nbsp;
		   		   <input type="reset" name="" id="" value="重填"/>
	   		   </td>
	   		  </tr>
	   		 </table>
	   		 </div>
	   	</form>
  </body>
</html>
