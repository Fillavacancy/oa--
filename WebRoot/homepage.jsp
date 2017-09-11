<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>卓越办公系统</title>
    <script src="js/jquery1.8.3.js" type="text/javascript"></script>
	<script src="js/homepage.js" type="text/javascript"></script>
	<link href="css/homepage.css" type="text/css" rel="stylesheet"/>
  	<script src="js/Twodimen.js"    type="text/javascript"></script>
 	<link href="css/Twodimen.css" type="text/css" rel="stylesheet"> 
	<script type="text/javascript" src="js/Online_service.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){ 
		    //var query=location.search.substring(1);//获取查询串   
		    //var pairs=query.split("&");//在逗号处断开   
		    //if(pairs == "type=1")
		    //{
			//	var UserInfo = document.getElementById("UserInfo");
			//	UserInfo.innerHTML = "1";
		    //}
		}); 
	</script>
  </head>
  
  <body>
  	  <div align="center">
  	  <div style="width: 100%" id="flmtopdiv"><hr/></div>
  		<div style=" height: 25px; line-height:25px; background-color: #F1E4F1;padding-left: 1000px;">
  			<label id="flmleftlbl">&nbsp;</label>
  			<a href="ObtainCodeServlet?type=1" class="registera"  id="UserInfo">登录${sessionScope.user.userName }</a>
  			<label id="flmrightlbl">&nbsp;</label>
  			<a href="#" class="registera" >注册</a>
  		</div>
  		<div align="center" id="headretdiv">
  			<img src="images/Login.png" id="headimg">
  			<div id="userdiv">
				<table width="80px" height="60px" style=" background-color: #F1E4F1; font-size: 12px; text-align: center; b">
					<tr>
						<td style="border-bottom:solid 1px #d00;">
							<a href="#">个人设置</a>
						</td>
					</tr>
					<tr>
						<td style="border-bottom:solid 1px #d00;">
							<a href="#">退出</a>
						</td>
					</tr>
				</table>  			
  			</div>
  		</div>
  		<div style="background-image: url('images/title1.png'); " id="titlediv" align="center">
  			<table id="titletable">
  				<tr>
  					<td><a id="select_a1" href="homepage.jsp">卓越首页</a><span>|</span></td>
  					<td><a id="select_a" href="#">日常办公</a><span>|</span></td>
  					<td><a id="select_a2" href="#">信息发布</a><span>|</span></td>
  					<td><a id="select_a3" href="#">公文管理</a><span>|</span></td>
  					<td><a id="select_a4" href="#">事务管理</a><span>|</span></td>
  					<td><a id="select_a5" href="#">联系卓越</a></td>
  				</tr>
  			</table>
		</div>
	<div id="select_div" style="font-size: 14px; position: absolute; width:230px;
    height:30px; text-align:center; line-height:30px; border:solid 1px blue;
    margin-left:310px; background-color: #66b3ff;">
  			<a href="#" onclick="Officemail()" style="text-decoration: none;">办公邮件</a>
  			<a href="#" onclick="" style=" text-decoration: none;">个人办公</a>
  			<a href="#" onclick="" style=" text-decoration: none;">公文处理配置</a>
  	</div>
  	<div id="select_div2" style="font-size: 14px;  position: absolute; width:230px;
    height:30px; text-align:center; line-height:30px; border:solid 1px blue;
    margin-left:485px; background-color: #66b3ff;">
  			<a href="#" style="text-decoration: none;"> WEB信息维护</a>
  	</div>
  	<div id="select_div3" style="font-size: 14px;  position: absolute; width:230px;
    height:30px; text-align:center; line-height:30px; border:solid 1px blue;
    margin-left:665px; background-color: #66b3ff;">
  			<a href="#" style="text-decoration: none;"> 公文管理的使用</a>
  			<a href="#" style=" text-decoration: none;">公文处理配置</a>
  	</div>
  	<div id="select_div4" style="font-size: 14px;  position: absolute; width:430px;
    height:30px; text-align:center; line-height:30px; border:solid 1px blue;
    margin-left:735px; background-color: #66b3ff;">
  			<a href="#" style=" text-decoration: none;">会议管理</a>
  			<a href="#" style=" text-decoration: none;">电话记录模块</a>
  			<a href="#" style=" text-decoration: none;">用车管理模块</a>
  			<a href="#" style=" text-decoration: none;">用章管理模块</a>
  			<a href="#" style=" text-decoration: none;">用餐管理模块</a>
  	</div>
  	<div id="select_div5" style="font-size: 14px;  position: absolute;width:380px;
    height:30px; text-align:center; line-height:30px; border:solid 1px blue;
    margin-left:785px; background-color: #66b3ff;">
  			<a href="#" style=" text-decoration: none;">联系电话</a>
  			<a href="#" style=" text-decoration: none;">电子地图</a>
  			<a href="#" style=" text-decoration: none;">在线预约</a>
  			<a href="#" style=" text-decoration: none;">职位申请</a>
  			<a href="#" style=" text-decoration: none;">在线预约</a>
  	</div>
  	  	<iframe id="common"  src="common.jsp" width="100%" height="135%" frameborder="0" scrolling="no"></iframe>
  	  	<div id="pop" > 
	  		<div id="popClose">  		
	    	<a href="#" onclick="closediv()" title="点击关闭">关闭窗口</a>
	  		</div>
	    	<div id="popContent"> 
	    		<a href="#" target="_blank"><img src="images/weixin_blue.jpg"></a> 
	    	</div> 
		</div>
  	<div align="center" class="topdiv">
  	<br/>
  		<label class="txtone">
  		<a href="#">卓越首页</a> | 
  		<a href="#">日常办公 </a> |
  		<a href="#">信息发布</a> | 
  		<a href="#">公文管理</a> | 
  		<a href="#">事务管理</a> | 
  		<a href="#">联系卓越</a>
  		</label>
  		<br/>
  		<label class="txtone">版权所有：成都卓越软件 四川卓越财务软件ERP系统 卓越OA 畅捷通四川软件服务中心卓越普信 公司地址：成都市武青东四路西部智谷D区</label>
  		<br/>
  		<label class="txtone">电话：028-********* / ******** 传真：028-********** 技术支持：<a href="#">****西部商务网</a></label>
  		<br/><br/>
  	</div>
  	<div align="center" >
  		<table >
  			<tr>
  				<td><img alt="公安局" src="images/gongguan.png"></td>
  				<td><a href="#" class="txttwo">川公网安备 51010702000493号</a></td>
  			</tr>
  		</table>
  	</div>
 </div>
  </body>
</html>