/**
 * 
 */


function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function changeNavBar(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		console.log("entered");
		if (res.isManager == 1) {
			var nav = document.getElementById("employeesNav");
			nav.style.display = 'block';
		}
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project1/session", changeNavBar);
}