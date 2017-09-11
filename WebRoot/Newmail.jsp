<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
   <script src="js/jquery1.8.3.js" type="text/javascript"></script>
  <link href="css/Newmail.css" type="text/css" rel="stylesheet"> 
  <script type="text/javascript">
	  $(document).ready(function(){ 
		  var date = new Date();
		  var seperator1 = "-";
		  var seperator2 = ":";
		  var month = date.getMonth() + 1;
		  var strDate = date.getDate();
		  if (month >= 1 && month <= 9) {
		      month = "0" + month;
		  }
		  if (strDate >= 0 && strDate <= 9) {
		      strDate = "0" + strDate;
		  }
		  var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
		          + " " + date.getHours() + seperator2 + date.getMinutes();
		  var date = document.getElementById("year");
		  date.innerHTML = currentdate;
		}); 
		//重置邮箱
		function deleteInfo()
		{
			$("#txt_Receivemail").attr("value","");
			$("#txt_Duplicate").attr("value","");
			$("#txt_Bcc").attr("value","");
		}
		//发送存草稿请求
		$(function() {
			$("#btn_Savedrafts").click(function() {
				var shou = $("#txt_Receivemail").val();
				var chao = $("#txt_Duplicate").val();
				var mi = $("#txt_Bcc").val();
				var subject = $("#txt_Theme").val();
				var accessory = $("#accessory").val();
				var content = $("#comments").val();
				var url = "${pageContext.request.contextPath}/DraftsServlet";
				var args = {"shou":shou,"chao":chao,"mi":mi,"subject":subject,
						    "accessory":accessory,"content":content,"time":new Date()};
				$.post(url,args,function(data){
					alert(data);
				});
			});
		});
		//发送邮件请求
		$(function() {
			$("#btn_Justsend").click(function() {
				var shou = $("#txt_Receivemail").val();
				var chao = $("#txt_Duplicate").val();
				var mi = $("#txt_Bcc").val();
				var subject = $("#txt_Theme").val();
				var accessory = $("#accessory").val();
				var content = $("#comments").val();
				var url = "${pageContext.request.contextPath}/SendUserMailServlet";
				var args = {"shou":shou,"chao":chao,"mi":mi,"subject":subject,
						    "accessory":accessory,"content":content,"time":new Date()};
				$.post(url,args,function(data){
					alert(data);
				});
			});
		});
  </script>
  <%
		String shou=request.getParameter("shou");
		String chao=request.getParameter("chao");
		String mi=request.getParameter("mi");
		request.setAttribute("shou",shou);
		request.setAttribute("chao",chao);
		request.setAttribute("mi",mi);
	%>
  </head>
  
  <body>
  	<div id="budge">
	  	<form action="">
	  		<div>
	  			<table>
	  				<tr>
	  					<td><label>${sessionScope.user.userName }</label></td>
	  					<td><label id="year"></label></td>
	  				</tr>
	  			</table>  			
	  		</div>
	  		<div id="Newmail">  		
	  			<div style="text-align: center;background-color: #F1E4F1;width: 737;height: 20px;font-family: 宋体;font-size: 18px;color: #FFF;">
	  				<span>写&nbsp;邮&nbsp;件</span>
	  			</div>
	  			<div style="text-align: center; margin-top: 3px;">
	  				<a href="Address.jsp">[公共通讯录]</a><a href="Personal.jsp">[私人通讯录]</a>  	
	  				<hr/ style="border:1px solid #E0DEDE;">			
	  			</div>
	  			<div>
	  				<span class="Calligraphy">收邮件：</span>
	  				<input class="tex_box" name="txt_Receivemail" type="text" maxlength="20" id="txt_Receivemail" value="${shou }"/>
	  				<hr/ style="border:1px solid #E0DEDE;">	
	  			</div>
	  				<div>
	  					<span class="Calligraphy">抄&nbsp;&nbsp;&nbsp;送：</span>
	  					<input class="tex_box" name="txt_Duplicate" type="text" maxlength="20" id="txt_Duplicate" value="${chao }"/>
	  					<hr/ style="border:1px solid #E0DEDE;">	
	  				</div>
	  				<div>
	  					<span class="Calligraphy">密&nbsp;&nbsp;&nbsp;送：</span>
	  					<input class="tex_box" name="txt_Bcc" type="text" maxlength="20" id="txt_Bcc" value="${mi }"/>
	  					<hr/ style="border:1px solid #E0DEDE;">	
	  				</div>
					<div>
						<span class="Calligraphy">主&nbsp;&nbsp;&nbsp;题：</span>
						<input class="tex_box" name="txt_Theme" type="text" maxlength="20" id="txt_Theme"/>
						<hr/ style="border:1px solid #E0DEDE;">	
					</div>
					<div>
						<span class="Calligraphy">附&nbsp;&nbsp;&nbsp;件：</span>
						<input tabindex="3" size="3" id="accessory" name="report" type="file"  onchange="document.getElementById('btn_Enclosure').value=this.value" style="width: 70px;"/>				
						<input type="text"  id="btn_Enclosure" size="56px;" />
					</div>
	  		</div>
	  		<div style="margin-top: 10px;margin-left: -1px;">
	  			<table>
	  				<tr>
	  					<td><input class="btn_Sendsave" name="btn_Sendsave" type="button" id="btn_Sendsave" value="发送并保存"/></td>
	  					<td><input class="btn_Justsend" name="btn_Justsend" type="button" id="btn_Justsend" value="只发送"/></td>
	  					<td></td>
	  					<td><input class="btn_Savedrafts" name="btn_Savedrafts" type="button" id="btn_Savedrafts" value="存草稿"/></td>
	  					<td></td>
	  					<td><input class="btn_Rewritemail" name="btn_Rewritemail" type="reset" id="btn_Rewritemail" onclick="deleteInfo()" value="重写邮件"/></td>
	  				</tr> 
	  					<textarea id="comments" rows="20"  cols="103" ></textarea>
	  			</table>
	  		</div>
	  	</form>
	</div> 
  </body>
</html>
