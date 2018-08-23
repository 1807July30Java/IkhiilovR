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

function populateEmployee(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res.username) {
			document.getElementById("username").innerText = res.username;
			document.getElementById("password").innerText = res.password;
			document.getElementById("firstName").innerText = res.firstName;
			document.getElementById("lastName").innerText = res.lastName;
			document.getElementById("manager").innerText = res.manager;
			document.getElementById("email").innerText = res.email;
		}
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project1/session", populateEmployee);
}