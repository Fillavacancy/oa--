<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  <script src="js/jquery1.8.3.js" type="text/javascript"></script>
  <script src="js/UnchainRequest.js" type="text/javascript"></script>
  <link href="css/Unchain.css" type="text/css" rel="stylesheet"> 
  <script type="text/javascript">
  $(document).ready(function() {
		$.ajax( {
			type : "post",
			url : "${pageContext.request.contextPath}/SearchEncryptedAll",
			cache : false,
			data : {"time" : new Date()},
			dataType : 'json',
			success : function(json) {
				$(json).each(function(){
					var selector = document.getElementById('Cryptoguard');
					var opp = new Option(this.encrName,this.encrId);
					opp.name = "option1";
					selector.add(opp);
				});
			}
		}, "json");
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
		var url = "${pageContext.request.contextPath}/ObtainCodeServlet";
		var args = {"time":new Date()};
		$.post(url,args,function(data){
			$("#nextCode").val(data);
		});
	}); 
  $(function() {
		$("#submit").click(function() {
			var Dealernumber = $("#txt_Dealernumber").val();
			var Cryptoguard = $("#Cryptoguard").val();
			var Answer = $("#txt_Answer").val();
			var ValidCode = $("#txt_ValidCode").val();
			if(Dealernumber != "" && Cryptoguard != "" && Answer != "" && ValidCode != "")
			{
				var name = Number(Dealernumber);
				if(isNaN(name))
				{
		            alert("请输入数字！");
		            return false;
				}
				var url = "${pageContext.request.contextPath}/DeblockingServlet";
				var args = {"Dealernumber":Dealernumber,"Cryptoguard":Cryptoguard,"Answer":Answer,
						   "ValidCode":ValidCode,"time":new Date()};
				$.post(url,args,function(data){
					alert(data);
					if(data == "恭喜、账号解锁成功!")
					{
						window.open("Login.jsp","_self");
					}
				});
			}
		});
	});
	
  </script>
  <title>卓越办公系统</title>
  </head>
  
  <body style="background:url('images/Unchain.png') no-repeat; height: 600px;">
  		<div>
  			<span id="Logo"><img src="images/Logo.png"/></span>
  			<div id="Unchain_Move">
  				<table border="0" cellpadding="0" align="center">
  				<tr>
  					<td colspan="2" align="right" class="Typeface" id="interval">解锁方式：</td>
  					<td id="interval">
  						<select name="ddlLoginType" id="Secret_Question" style="width: 172px;">
  							<option value="1">密保问题</option>
  						</select>
  					</td>		
  				</tr>
  				<tr>
  					<td align="right" class="Typeface" id="interval">用户编号：</td>
  					<td id="interval"><input name="txt_Dealernumber" type="text" maxlength="20" id="txt_Dealernumber" style="width: 172px;"/></td>
  				</tr>
  				<tr>
  					<td align="right" class="Typeface" id="interval">密码保护问题：</td>
  					<td align="left" id="interval">
  						<select name="Cryptoguard" id="Cryptoguard" style="width: 172px;">
  							
  						</select>
  					</td>
  				</tr>
  				<tr>
  					<td align="right" class="Typeface" id="interval">答案：</td>
  					<td id="interval"><input name="txt_Answer" type="password" id="txt_Answer" maxlength="20" style="width: 172px;"/></td>
  				</tr>
  				<tr>
  					<td align="right" class="Typeface" id="interval">验&nbsp;证&nbsp;码：</td>
  					<td id="interval"><input name="txt_ValidCode" type="text" id="txt_ValidCode" maxlength="10" style="width: 172px;"/></td>
  					<td ><input type="text" id="nextCode" value="" name="code" onclick="" style="width: 50px; font-style: italic;letter-spacing:3px;" readonly="readonly"/></td>
  					<td ><a href="#" style="margin:0px 0px 0px 4px;" id="next">换一张?</a></td>
  				</tr>
  				<tr>
                    <td align="left" >
                       <span style="margin: 0px 0px 0px 90px; color: #999999;font-size: 12px;">
                       <span id="lblallnum">这里都是数字0，没有字母o，也不区分大小写</span>
                       </span>
                     </td>
                </tr>
  			</table>
  			<span class="btu_Deblocking">
  				<a href="#" id="submit"><img src="images/Deblocking.png" id="btu_Deblocking"/></a>
  			</span>
  			<span class="btu_Secede">
  				<a href="Login.jsp" ><img src="images/Secede.png" id="btu_Secede"/></a>
  			</span>
  			</div> 			
  		</div>
  </body>
</html>
