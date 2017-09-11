var array = new Array("images/home1.png","images/home2.png","images/home3.png","images/home4.png","images/home5.png","images/home6.png","images/home7.png");
var i = 3;
function a()
{
	if(i==array.length)
		i=0;
	$("#homeimg").attr("src",array[i++]);
}
window.setInterval("a()", 3000);

// 导航栏下手动切换大图片
function t1(id) {
	var homeimg = document.getElementById("homeimg");
	switch (id) {
	case "img":
		homeimg.src = "images/home1.png";
		document.getElementById("img").src = "images/smimg.png";
		document.getElementById("img2").src = "images/smhome.png";
		document.getElementById("img3").src = "images/smhome.png";
		document.getElementById("img4").src = "images/smhome.png";
		document.getElementById("img5").src = "images/smhome.png";
		document.getElementById("img6").src = "images/smhome.png";
		document.getElementById("img7").src = "images/smhome.png";
		break;
	case "img2":
		homeimg.src = "images/home2.png";
		document.getElementById("img2").src = "images/smimg.png";
		document.getElementById("img").src = "images/smhome.png";
		document.getElementById("img3").src = "images/smhome.png";
		document.getElementById("img4").src = "images/smhome.png";
		document.getElementById("img5").src = "images/smhome.png";
		document.getElementById("img6").src = "images/smhome.png";
		document.getElementById("img7").src = "images/smhome.png";
		break;
	case "img3":
		homeimg.src = "images/home3.png";
		document.getElementById("img3").src = "images/smimg.png";
		document.getElementById("img").src = "images/smhome.png";
		document.getElementById("img2").src = "images/smhome.png";
		document.getElementById("img4").src = "images/smhome.png";
		document.getElementById("img5").src = "images/smhome.png";
		document.getElementById("img6").src = "images/smhome.png";
		document.getElementById("img7").src = "images/smhome.png";
		break;
	case "img4":
		homeimg.src = "images/home4.png";
		document.getElementById("img4").src = "images/smimg.png";
		document.getElementById("img").src = "images/smhome.png";
		document.getElementById("img2").src = "images/smhome.png";
		document.getElementById("img3").src = "images/smhome.png";
		document.getElementById("img5").src = "images/smhome.png";
		document.getElementById("img6").src = "images/smhome.png";
		document.getElementById("img7").src = "images/smhome.png";
		break;
	case "img5":
		homeimg.src = "images/home5.png";
		document.getElementById("img5").src = "images/smimg.png";
		document.getElementById("img").src = "images/smhome.png";
		document.getElementById("img2").src = "images/smhome.png";
		document.getElementById("img3").src = "images/smhome.png";
		document.getElementById("img4").src = "images/smhome.png";
		document.getElementById("img6").src = "images/smhome.png";
		document.getElementById("img7").src = "images/smhome.png";
		break;
	case "img6":
		homeimg.src = "images/home6.png";
		document.getElementById("img6").src = "images/smimg.png";
		document.getElementById("img").src = "images/smhome.png";
		document.getElementById("img2").src = "images/smhome.png";
		document.getElementById("img3").src = "images/smhome.png";
		document.getElementById("img4").src = "images/smhome.png";
		document.getElementById("img5").src = "images/smhome.png";
		document.getElementById("img7").src = "images/smhome.png";
		break;
	case "img7":
		homeimg.src = "images/home7.png";
		document.getElementById("img7").src = "images/smimg.png";
		document.getElementById("img").src = "images/smhome.png";
		document.getElementById("img2").src = "images/smhome.png";
		document.getElementById("img3").src = "images/smhome.png";
		document.getElementById("img4").src = "images/smhome.png";
		document.getElementById("img5").src = "images/smhome.png";
		document.getElementById("img6").src = "images/smhome.png";
		break;
	}
}
// 三小标题图片切换动态效果
function lblimg_1(id) {
	var lblimg1 = document.getElementById("lblimg_1");
	var lblimg2 = document.getElementById("lblimg_2");
	var lblimg3 = document.getElementById("lblimg_3");
	switch (id) {
	case "lblimg_1":
		lblimg1.style.background = 'url(images/dt.png)';
		lblimg2.style.background = 'url(images/bt.png)';
		lblimg3.style.background = 'url(images/bt.png)';
		break;
	case "lblimg_2":
		lblimg2.style.background = 'url(images/dt.png)';
		lblimg1.style.background = 'url(images/bt.png)';
		lblimg3.style.background = 'url(images/bt.png)';
		break;
	case "lblimg_3":
		lblimg3.style.background = 'url(images/dt.png)';
		lblimg1.style.background = 'url(images/bt.png)';
		lblimg2.style.background = 'url(images/bt.png)';
		break;
	}
}
function lblimg_2() {
	var lblimg1 = document.getElementById("lblimg12340" + "");
	switch (id) {
	case "lblimg1234":
		lblimg1.style.background = 'url(images/dt.png)';
		break;
	}
}
function lblimg_3() {
	var lblimg = document.getElementById("lblimg123");
	lblimg.style.background = 'url(images/dt.png)';
}
// 三图片小标题内容切换
function sizetd(id) {
	var a1 = document.getElementById("sizetd_a_1");
	var a2 = document.getElementById("sizetd_a_2");
	var a3 = document.getElementById("sizetd_a_3").value;

	switch (id) {
	case "sizetd_a_1":
		a1.values = "卓越科技与向远科技签约成功！";
		break;
	case "sizetd_a_2":
		a2.values = "卓越科技与向远科技签约成功！";
		break;
	case "sizetd_a_3":
		var s = "卓越科技与向远科技签约成功";
		s = a3;
		break;
	}
}
$(document).ready(function() {
	$("#lblimg_1").mouseover(function() {
		$("#sizetd_a_1").text("·北京青年政治学院签约卓越软件");
		$("#sizetd_a_2").text("·卓越优普: HAPPY+的O2O之路");
		$("#sizetd_a_3").text("·卓越IUAP Mobile移动互联网+走进成都");
		$("#sizetd_a_4").text("·王文京：互联网+驱动企业未来发展");
		$("#sizetd_a_5").text("·卓越杜宇：传统企业做电子商务应首先改变理念");
		$("#sizetd_a_6").text("·离散制造再掀高潮，用友U9新机遇如何发力？");
		$("#sizetd_a_7").text("·王文京：信息化的春天已经到来");
		$("#sizetd_a_8").text("·【卓越优普】打造互联网时代企业应用的DN");
		$("#sizetd_a_9").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_10").text("·马红妮：U9变得 “更聚焦，更精准，更专业”");
	});
	$("#lblimg_2").mouseover(function() {
		$("#sizetd_a_1").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_2").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_3").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_4").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_5").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_6").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_7").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_8").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_9").text("卓越科技与向远科技签约成功");
		$("#sizetd_a_10").text("卓越科技与向远科技签约成功");
	});
	$("#lblimg_3").mouseover(function() {
		$("#sizetd_a_1").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_2").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_3").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_4").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_5").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_6").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_7").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_8").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_9").text("·数据驱动：企业平台移动化");
		$("#sizetd_a_10").text("·数据驱动：企业平台移动化");
	});

});