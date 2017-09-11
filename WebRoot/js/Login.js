function onchanges() {

	var name1 = document.getElementById("ddlLoginType");
	var lbl = document.getElementById("lblLogTip");
	if (name1.value == "编号") {
		lbl.innerHTML = "编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号";
	}
	if (name1.value == "用户名") {
		lbl.innerHTML = "用&nbsp;户&nbsp;名";
	}
}
