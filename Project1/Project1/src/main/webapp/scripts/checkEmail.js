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

function checkEmailAjax(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res.smtp_check) {
			var nav = document.getElementById("registerSubmit");
			nav.style.display = 'block';
			var emailBtn = document.getElementById("emailBtn");
			emailBtn.style.display = 'none';
			var modalBody = document.getElementById("modalBody");
			modalBody.innerText = "Congrats Your Email is Valid! Proceed to Register";
		}else if(res.did_you_mean != ""){
			var modalBody = document.getElementById("modalBody");
			modalBody.innerText = "Sorry Your Email is Invalid! Did you mean: " + res.did_you_mean
			+ "?";
		}else{
			var modalBody = document.getElementById("modalBody");
			modalBody.innerText = "Sorry Your Email is Invalid! Enter a Valid Email Please.";
		}
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

function checkEmail() {
	var email = document.getElementById("email").value;
	var emailURL = "http://apilayer.net/api/check?access_key=fde64fc0464aac72f7dd6ab57189a437&email=" +
			email +
			"&smtp=1&format=1";
	console.log(email);
	sendAjaxGet(emailURL, checkEmailAjax);
}