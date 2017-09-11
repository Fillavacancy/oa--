<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>四川成都卓越有限科技公司</title>
    <script src="js/jquery1.8.3.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
	<link href="css/common.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
  	<div style="width: 100%;height: 100%;">
  	<div align="center">
  	<table>
  		<tr>
  			<td  width="990px" height="350px;"id="hometd" style="background-image: url('images/home1.png');">
  				<img id="homeimg" alt="" src="images/home3.png">
  				<p>
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img" />
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img2" />
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img3" />
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img4" />
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img5" />
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img6" />
  				<img onmouseover="t1(id)" onmouseout="t2(id)" src="images/smhome.png" id="img7" />
  				</p>
  			</td>
  		</tr>
  	</table>
  	</div>
  	<div align="center">
  		<img alt="" src="images/newmessage.png" id="mynewimg">
  		<marquee scrollAmount=5 scrollDelay=77 direction="left" width=67% height=20
		onmouseout="this.start()" onmouseover="this.stop()"> 
		您好，成都卓越普信信息技术有限公司作为卓越授权服务中心及钻石级合作伙伴，
		倡导“一直向前，卓越未来”的理念。努力为公司的新老用户提供周到、细致、真诚的服务。
		本季爱心课堂-卓越软件培训安排已经出炉，欢迎您的聆听！
		</marquee>
  	</div>
  	<br/>
  	<div align="center" id="headdiv">
  		<table  width="77%" style="border: solid 1px #F0F8FF;">
  			<tr>
  				<td height="300px;">
  					<table >
  						<tr>
  							<td><strong><label id="lblimg_1" onmouseover="lblimg_1(id)" class="lblimg" style="background-image: url('images/bt.png');">卓越动态</label></strong><strong><label id="lblimg_2" class="lblimg" onmouseover="lblimg_1(id)" style="background-image: url('images/bt.png');">卓越日常</label></strong><strong><label id="lblimg_3" onmouseover="lblimg_1(id)" class="lblimg" style="background-image: url('images/bt.png');">卓越外交</label></strong>
  							</td>
  						</tr>
  						<tr>
  							<td class="sizetd"><a href="#" id="sizetd_a_1">·北京青年政治学院签约卓越软件</a></td>
  							<td class="sizetd2" id="sizetd_td2_1">2016-7-28</td>
  						</tr>
  						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_2">·卓越优普: HAPPY+的O2O之路</a></td>
  							<td class="sizetd2" id="sizetd_td2_2">2016-6-18</td>
						</tr>
						<tr>
  							<td class="sizetd"><a href="#" id="sizetd_a_3">·卓越IUAP Mobile移动互联网+走进成都</a></td>
  							<td class="sizetd2" id="sizetd_td2_3">2015-5-29</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_4">·王文京：互联网+驱动企业未来发展</a></td>
  							<td class="sizetd2" id="sizetd_td2_4">2015-7-17</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_5">·卓越杜宇：传统企业做电子商务应首先改变理念</a></td>
  							<td class="sizetd2" id="sizetd_td2_5">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_6">·离散制造再掀高潮，用友U9新机遇如何发力？</a></td>
  							<td class="sizetd2" id="sizetd_td2_6">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_7">·王文京：信息化的春天已经到来</a></td>
  							<td class="sizetd2" id="sizetd_td2_7">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_8">·【卓越优普】打造互联网时代企业应用的DN</a></td>
  							<td class="sizetd2" id="sizetd_td2_8">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_9">·数据驱动：企业平台移动化</a></td>
  							<td class="sizetd2" id="sizetd_td2_9">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_10">·马红妮：U9变得 “更聚焦，更精准，更专业”</a></td>
  							<td class="sizetd2" id="sizetd_td2_10">2014-4-4</td>
  						</tr>		
  					</table>
  				</td>
  				<td>
  					<table >
  						<tr>
  							<td><strong><label id="lblimg1234" onmouseover="lblimg_2();" class="lblimg" style="background-image: url('images/bt.png');">卓越动态</label></strong>
  							</td>
  						</tr>
  						<tr>
  							<td class="sizetd"><a href="#" id="sizetd_a_1">·北京青年政治学院签约卓越软件</a></td>
  							<td class="sizetd2" id="sizetd_td2_1">2016-7-28</td>
  						</tr>
  						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_2">·卓越优普: HAPPY+的O2O之路</a></td>
  							<td class="sizetd2" id="sizetd_td2_2">2016-6-18</td>
						</tr>
						<tr>
  							<td class="sizetd"><a href="#" id="sizetd_a_3">·卓越IUAP Mobile移动互联网+走进成都</a></td>
  							<td class="sizetd2" id="sizetd_td2_3">2015-5-29</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_4">·王文京：互联网+驱动企业未来发展</a></td>
  							<td class="sizetd2" id="sizetd_td2_4">2015-7-17</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_5">·卓越杜宇：传统企业做电子商务应首先改变理念</a></td>
  							<td class="sizetd2" id="sizetd_td2_5">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_6">·离散制造再掀高潮，用友U9新机遇如何发力？</a></td>
  							<td class="sizetd2" id="sizetd_td2_6">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_7">·王文京：信息化的春天已经到来</a></td>
  							<td class="sizetd2" id="sizetd_td2_7">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_8">·【卓越优普】打造互联网时代企业应用的DN</a></td>
  							<td class="sizetd2" id="sizetd_td2_8">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_9">·数据驱动：企业平台移动化</a></td>
  							<td class="sizetd2" id="sizetd_td2_9">2014-4-4</td>
  						</tr>
						<tr>	
  							<td class="sizetd"><a href="#" id="sizetd_a_10">·马红妮：U9变得 “更聚焦，更精准，更专业”</a></td>
  							<td class="sizetd2" id="sizetd_td2_10">2014-4-4</td>
  						</tr>		
  					</table>
  				</td>
  				<td>
  				<div>
  					<table  width="250px" height="295px" style="text-align: center;">
  						<tr>
  							<td style="text-align: left;vertical-align: top;"><strong><label id="lblimg123" onmouseover="lblimg_3()" class="lblimg" style="background-image: url('images/bt.png');">卓越动态</label></strong>
  							</td>
  						</tr>
						<tr>	
  							<td><a href="#"><img alt="" src="images/cpzx.png"></a></td>
  						</tr>
						<tr>	
  							<td><a href="#"><img alt="" src="images/cpzx.png"></a></td>
  						</tr>
						<tr>	
  							<td><a href="#"><img alt="" src="images/cpzx.png"></a></td>
  						</tr>
						<tr>	
  							<td><a href="#"><img alt="" src="images/cpzx.png"></a></td>
  						</tr>
						<tr>	
  							<td><a href="#"><img alt="" src="images/cpzx.png"></a></td>
  						</tr>
  					</table>
  				</div>
  				</td>
  			</tr>
  		</table>
  	</div>
  	<div align="center" style="height: 200px;">
  		<marquee scrollAmount=15 scrollDelay=77 behavior="scroll" direction="left" width=77% height=100% onmouseout="this.start()" onmouseover="this.stop()"> 
						<table>
							<tr>
								<td >
									<a href="#" style="text-decoration: none;"><img alt="" src="images/jgpz1.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/jgpz2.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/zdpz3.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/zdzb4.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/T3-bzb5.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/T6qygl6.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/cjtT+7.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/jgpz8.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/yyNC9.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/yyU8+10.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
								<td>
									<a href="#" style="text-decoration: none;"><img alt="" src="images/yhU11.png"><br/>&nbsp;&nbsp;&nbsp;1233</a>
								</td>
							</tr>
						</table>
		</marquee>
  	</div>
  	</div>
  </body>
</html>
