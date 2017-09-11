function changeReadmail()
{
	document.getElementById("changemail").src = "Readmail.jsp";
	//红色背景切换 
	document.getElementById("Readmail").style.backgroundColor="#F1E4F1";
	document.getElementById("Newmail").style.backgroundColor="";
	document.getElementById("peizhi").style.backgroundColor="";
	document.getElementById("personalbook").style.backgroundColor="";
}
function changeNewmail()
{
	document.getElementById("changemail").src = "Newmail.jsp";
	//红色背景切换 
	document.getElementById("Newmail").style.backgroundColor="#F1E4F1";
	document.getElementById("Readmail").style.backgroundColor="";
	document.getElementById("peizhi").style.backgroundColor="";
	document.getElementById("personalbook").style.backgroundColor="";
}
function changePeizhi()
{
	document.getElementById("changemail").src = "ExamineLoginServlet";
	//红色背景切换 
	document.getElementById("peizhi").style.backgroundColor="#F1E4F1";
	document.getElementById("Newmail").style.backgroundColor="";
	document.getElementById("Readmail").style.backgroundColor="";
	document.getElementById("personalbook").style.backgroundColor="";
}
function personalbook()
{
	document.getElementById("changemail").src = "SelPersonalbookServlet";
	//红色背景切换 
	document.getElementById("personalbook").style.backgroundColor="#F1E4F1";
	document.getElementById("Newmail").style.backgroundColor="";
	document.getElementById("Readmail").style.backgroundColor="";
	document.getElementById("peizhi").style.backgroundColor="";
}
function Outboxanddraftss()
{
	document.getElementById("changemail").src = "SelOutboxanddraftsServlet";
	//红色背景切换 
	document.getElementById("personalbook").style.backgroundColor="#F1E4F1";
	document.getElementById("Newmail").style.backgroundColor="";
	document.getElementById("Readmail").style.backgroundColor="";
	document.getElementById("peizhi").style.backgroundColor="";
}
