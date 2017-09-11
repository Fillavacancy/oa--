function Officemail() {
	document.getElementById("common").src = "Officemail.jsp";
	document.getElementById("common").height = "100%";
}
$(function() {
	$("#userdiv").hide();
	$("#UserInfo").mouseover(function() {
		var i = $("#UserInfo").html();
		if (i != "登录") {
			$("#userdiv").show();
		}
	});
	$("#userdiv").mouseout(function() {
		$(this).hide();
	});
	$("#userdiv").mouseover(function() {
		$(this).show();
	});
});
$(function() {
	$("#flmtopdiv,#flmleftlbl,#flmrightlbl").mouseover(function() {
		$("#userdiv").hide();
	});
});
$(function() {
	$("#select_a1").mouseover(function() {
		$("#select_div").hide();
		$("#select_div2").hide();
		$("#select_div3").hide();
		$("#select_div4").hide();
		$("#select_div5").hide();
	});
});
$(function() {
	$("#headretdiv").mouseover(function() {
		$("#select_div").hide();
		$("#select_div2").hide();
		$("#select_div3").hide();
		$("#select_div4").hide();
		$("#select_div5").hide();
	});
});
$(function() {
	$("#select_div").hide();
	// 显示隐藏
	$("#select_a").mouseover(function() {
		$("#select_div").show();
		$("#select_div2").hide();
		$("#select_div3").hide();
		$("#select_div4").hide();
		$("#select_div5").hide();
	});
	$("#select_a").mouseout(function() {
		$("#select_div").mouseover(function() {
			$("#select_div").show();
		});
		$("#select_div").mouseout(function() {
			$("#select_div").hide();
		});
	});
});
$(function() {
	$("#select_div2").hide();
	// 显示隐藏
	$("#select_a2").mouseover(function() {
		$("#select_div2").show();
		$("#select_div").hide();
		$("#select_div3").hide();
		$("#select_div4").hide();
		$("#select_div5").hide();
	});
	$("#select_a2").mouseout(function() {
		$("#select_div2").mouseover(function() {
			$("#select_div2").show();
		});
		$("#select_div2").mouseout(function() {
			$("#select_div2").hide();
		});
	});
});
$(function() {
	$("#select_div3").hide();
	// 显示隐藏
	$("#select_a3").mouseover(function() {
		$("#select_div3").show();
		$("#select_div").hide();
		$("#select_div2").hide();
		$("#select_div4").hide();
		$("#select_div5").hide();
	});
	$("#select_a3").mouseout(function() {
		$("#select_div3").mouseover(function() {
			$("#select_div3").show();
		});
		$("#select_div3").mouseout(function() {
			$("#select_div3").hide();
		});
	});
});
$(function() {
	$("#select_div4").hide();
	// 显示隐藏
	$("#select_a4").mouseover(function() {
		$("#select_div4").show();
		$("#select_div").hide();
		$("#select_div3").hide();
		$("#select_div2").hide();
		$("#select_div5").hide();
	});
	$("#select_a4").mouseout(function() {
		$("#select_div4").mouseover(function() {
			$("#select_div4").show();
		});
		$("#select_div4").mouseout(function() {
			$("#select_div4").hide();
		});
	});
});
$(function() {
	$("#select_div5").hide();
	// 显示隐藏
	$("#select_a5").mouseover(function() {
		$("#select_div5").show();
		$("#select_div").hide();
		$("#select_div2").hide();
		$("#select_div3").hide();
		$("#select_div4").hide();

	});
	$("#select_a5").mouseout(function() {
		$("#select_div5").mouseover(function() {
			$("#select_div5").show();
		});
		$("#select_div5").mouseout(function() {
			$("#select_div5").hide();
		});
	});
});
