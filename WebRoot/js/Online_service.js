var lastScrollY = 0;
function ad_www_zzjs_net() {
	var diffY;
	if (document.documentElement && document.documentElement.scrollTop) {
		diffY = document.documentElement.scrollTop;
	} else if (document.body)
		diffY = document.body.scrollTop;
	//alert(diffY);
	percent = .1 * (diffY - lastScrollY);
	if (percent > 0)
		percent = Math.ceil(percent);
	else
		percent = Math.floor(percent);
	document.getElementById("leftad_wwwzzjsnet").style.top = parseInt(document
			.getElementById("leftad_wwwzzjsnet").style.top)
			+ percent + "px";
	document.getElementById("right_ad_www_zzjs_net").style.top = parseInt(document
			.getElementById("right_ad_www_zzjs_net").style.top)
			+ percent + "px";
	lastScrollY = lastScrollY + percent;
	//alert(percent);
}

function hiden_wwwzzjs_net(names) {
	document.getElementById(names).style.display = 'none';
}
function wwwzzjsnet_scro(names) {
	if (screen.width <= 800) {
		hiden_wwwzzjs_net(names);
	}
}
zcode = "<div id='leftad_wwwzzjsnet'></div>";
ycode = "<div id='right_ad_www_zzjs_net' style='right:10px;position: absolute;z-index:1;top:100px;width:107px;height:425px;'><div style='width:107px;height:425px;'><a href=http:\/\/www.zzjs.net target=_blank><img src=images/Online_service.png border=0><\/a></div><div align='center' style='position: absolute;margin-top: -36px;margin-left:12px;'>　<img src='images/Close_consultation.png' title='关闭' onclick=hiden_wwwzzjs_net('right_ad_www_zzjs_net') style='cursor:pointer'></div></div>";
document.write(zcode);
document.write(ycode);
wwwzzjsnet_scro('leftad_wwwzzjsnet');
wwwzzjsnet_scro('right_ad_www_zzjs_net');
window.setInterval("ad_www_zzjs_net()", 1);