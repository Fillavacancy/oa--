<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  <script src="js/jquery1.8.3.js" type="text/javascript"></script>
  <link href="css/Address.css" type="text/css" rel="stylesheet"> 
  <script type="text/javascript">
  $(document).ready(function() {
		$.ajax( {
			type : "post",
			url : "${pageContext.request.contextPath}/SelDeptAllServlet",
			cache : false,
			data : {"time" : new Date()},
			dataType : 'json',
			success : function(json) {
				$(json).each(function(){
					var selector = document.getElementById('CryptoguardDept');
					var opp = new Option(this.deptName,this.deptId);
					opp.name = "option1";
					selector.add(opp);
				});
			}
		}, "json");
	});
  function changeIndex()
	{
		$("#CryptoguardEmp").empty();//每次清空select的值
		var temp = $("#CryptoguardDept").val();
		var url = "${pageContext.request.contextPath}/SelUserAllJsonServlet";
		var args = {"DeptType":temp };
		$.post(url,args,function(json) {
			$(json).each(function(){
				var selector = document.getElementById('CryptoguardEmp');
				var opp = new Option(this.userName,this.userId);
				opp.name = "option1";
				selector.add(opp);
			});
		},"json");
	}
  function addshou(temp)
	{
		var type = null;
	   if(temp == "shou")
	   {
		   type = "#shou";
	   }
	   if(temp == "chao")
	   {
		   type = "#chao";
	   }
	   if(temp == "mi")
	   {
		   type = "#mi";
	   }
	    var str = [];
		var select = document.getElementById("CryptoguardEmp");
		for(i=0;i<select.length;i++){
			if(select.options[i].selected){
				str.push(select[i].text);
			}
		}
		$(type).text(str);
	}
	function deleteAlls()
	{
		$("#shou").text("");
		$("#chao").text("");
		$("#mi").text("");
	}
  </script>
  	<% 
  		String shou =   request.getParameter("shou");
  		String chao =   request.getParameter("chao");
  		String mi =   request.getParameter("mi");
  	%>
  </head>
  
  <body>
  	<div>
  		<form action="Newmail.jsp?shou=<%=shou %>?chao=<%=chao %>?mi=<%=mi %>">
	  		<div style=" background-color: #F1E4F1; width: 700px;" align="center">
	  			<span style="font-family: 宋体 ; font-size: 18px; color: #fff;">公共通讯录</span>
	  		</div>  	
	  		<div style="padding-top: 12px;float: left; margin-right: 105px;">
	  			<table style="width: 100%;">
	  				<tr>
	  					<td style="font-size: 12px;font-family: 宋体;">选择所在分类</td>
	  				</tr>
	  				<tr>
	  					<td>
							<select onchange="changeIndex()" style="width: 260px; overflow:scroll;overflow-x:hidden" id="CryptoguardDept">
							</select>
						</td>
	  				</tr>
	  				<tr>
	  					<td style="font-size: 12px;font-family: 宋体;">选择个人或者群组</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<select multiple="multiple" style="width: 260px; height: 400px;" id="CryptoguardEmp">
	  						</select>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td style="font-family: 宋体;font-size: 12px;">提示： 配合使用Ctrl键</td>
	  				</tr>
	  				<tr>
	  					<td style="font-family: 宋体;font-size: 12px;">或者Shift建可以一次选</td>
	  				</tr>
	  				<tr>
	  					<td style="font-family: 宋体;font-size: 12px;">择多个用户。</td>
	  				</tr>
	  			</table>
	  		</div>	
	  		<div id="memory" >
	  			<table style="margin-top: 30px;">
	  				<tr id="Recipient">
	  					<td><input type="button"  value="收件人>" onclick="addshou('shou')"/></td>
	  					<td id="text_box_1"><textarea rows="10" cols="34" name="shou" id="shou"  readonly="readonly"></textarea></td>	
	  				</tr>
	  				<tr id="Copyto">
	  					<td><input type="button"  value="抄送>" onclick="addshou('chao')"/></td>
	  					<td id="text_box_2"><textarea rows="10" cols="34" name="chao" id="chao" readonly="readonly"></textarea></td>	
	  				</tr>
	  				<tr id="blind">
	  					<td><input type="button"  value="密送> " onclick="addshou('mi')"/></td>
	  					<td id="text_box_3"><textarea rows="10" cols="34" name="mi" id="mi" readonly="readonly"></textarea></td>	
	  				</tr>  	
	  				<tr>
	  					<td></td>									
	  					<td>
	  					<input type="button"   value="删除" style="width: 60px;"/>&nbsp;&nbsp;&nbsp;&nbsp;
	  					<input type="button" id="deleteAll" onclick="deleteAlls()" value="删除所有" style="width: 80px;"/>
	  					</td>  				
	  				</tr>
	  			</table>	
	  		</div>
	  		<div style="border-top: solid 1px #008284; width: 700px; margin-top: 50px; padding-top: 10px;" align="center">
	  			<input type="submit" value="确定"/>
	  			&nbsp;&nbsp;&nbsp;&nbsp;
	  			<a href="Newmail.jsp"><input type="button" value="取消"/></a>
	  		</div>
	  	</form>
  	</div>
  </body>
</html>
