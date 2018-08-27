/**
 * 
 * 
 * 
 * function sendAjaxGet(url, func) { var xhr = new XMLHttpRequest() || new
 * ActiveXObject("Microsoft.HTTPRequest"); xhr.onreadystatechange = function() {
 * if (this.readyState == 4 && this.status == 200) { func(this); } };
 * xhr.open("GET", url, true); xhr.send(); };
 * 
 * function populateEmployee(xhr) { if (xhr.responseText) { var res =
 * JSON.parse(xhr.responseText); console.log(res); var urlCreator = window.URL ||
 * window.webkitURL; var imageUrl = urlCreator.createObjectURL(this.response);
 * document.querySelector("#image").src = imageUrl; } else { window.location =
 * "http://localhost:8084/Project1/login"; } };
 * 
 * 
 * window.onload = function() {
 * sendAjaxGet("http://localhost:8084/Project1/ManagerGetEmployees?entity=reimbursement&get=image",
 * populateEmployee); }
 */

window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project1/ManagerGetEmployees?entity=reimbursement&get=image");

}

function sendAjaxGet(url) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var data = this.responseText;

			const byteCharacters = atob(data);
			const byteArrays = [];
			const sliceSize = 512;
			for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
				const slice = byteCharacters.slice(offset, offset + sliceSize);
				const byteNumbers = new Array(slice.length);

				for (let i = 0; i < slice.length; i++) {
					byteNumbers[i] = slice.charCodeAt(i);
				}

				const byteArray = new Uint8Array(byteNumbers);
				byteArrays.push(byteArray);
			}

			var blob = new Blob(byteArrays, {
				type : 'image/jpg'
			});
			var image = document.getElementById('image');
			image.src = URL.createObjectURL(blob);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};
