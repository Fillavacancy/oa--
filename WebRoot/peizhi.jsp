<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
      <title></title>
	<script src="js/peizhi.js" type="text/javascript"></script>
  </head>
  <body>
   		
   		<div>
   		<div style="margin-top: 10px; ">
   		 <table border="1px" bordercolor="#DDD" cellpadding="0px" cellspacing="0px" width="737px">  
   		  <tr style="height: 22px">
   		   <td colspan="2" style="background-color:#F1E4F1;font: 18px bold; color: white;" align="center" >配置</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td onclick="changexiugai()" align="center" style="width: 110px;"><a href="#">密码</a></td>
   		   <td>重新设定邮箱的密码</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td onclick="changeDrafts()"  align="center" ><a href="#" >签名</a></td>
   		   <td>检查或修改发邮箱时的签名</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td align="center" ><a href="#">创建文件</a></td>
   		   <td>可以创建新文件</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td align="center" ><a href="#">删除文件</a></td>
   		   <td>可以选择删除数据库的现存文件</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td onclick="changeForwarding()" align="center" ><a href="#">自动转发</a></td>
   		   <td>检查或重新设定自动转发</td>
   		  </tr>
   		  <tr style="height: 32px">
   		   <td onclick="changeReply()" align="center" ><a href="#">自动回复</a></td>
   		   <td>重新设定自动回复的回信内容，或设置是否使用自动回复</td>
   		  </tr>
   		 </table>
   		 </div>
   			<div  style="width: 800px; position: absolute; top: 280px; left: 0px;">
	  			<iframe id="change"  src="" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>  	
	  		</div>
   		</div>
   		
  </body>
</html>
