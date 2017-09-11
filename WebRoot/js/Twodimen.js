var interval;
var divid = pop;
function start() {
	pop.visibility = "visible";
	interval = setInterval('changePos()', delay);
}
function pause_resume() {
	if (pause) {
		clearInterval(interval);
		pause = false;
	} else {
		interval = setInterval('changePos()', delay);
		pause = true;
	}
}
function closediv() {
	clearInterval(interval);
	pop.style.display = "none";
}
start();

