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
		for (var i = 0; i < res.length; i++) {

			var tableUsername = document
					.getElementById("employeeTableUsername");
			var rowUsername = document.createElement("tr");
			rowUsername.setAttribute("class", "row100 body");
			tableUsername.appendChild(rowUsername);

			var username = document.createElement("td");
			username.setAttribute("class", "cell100 column1");
			username.innerText = res[i].username;
			rowUsername.append(username);

			var table = document.getElementById("employeeTableBody");
			var row = document.createElement("tr");
			row.setAttribute("class", "row100 head");
			table.appendChild(row);

			var firstName = document.createElement("td");
			firstName.setAttribute("class", "cell100 column2");
			firstName.innerText = res[i].name;

			var lastName = document.createElement("td");
			lastName.setAttribute("class", "cell100 column3");
			lastName.innerText = res[i].lastname;

			var email = document.createElement("td");
			lastName.setAttribute("class", "cell100 column4");
			email.innerText = res[i].email;

			var password = document.createElement("td");
			password.setAttribute("class", "cell100 column5");
			password.innerText = res[i].password;

			var reimburseLink = document.createElement("button");

			reimburseLink.setAttribute("class", "cell100 column6");
			reimburseLink.setAttribute("id", res[i].id);
			reimburseLink.style.textAlign = "center";
			reimburseLink.innerText = "View"
			reimburseLink.setAttribute("class", "btn btn-info active");
			reimburseLink.onclick = reimburseTable;

			row.append(firstName, lastName, email, password, reimburseLink);

		}
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

function reimburseTable() {

	var table = document.getElementById("reimburseTable");
	table.style.display = 'block';

	var ajaxString = "http://localhost:8084/Project1/data?entity=allReimbursements&get="
			+ this.id;
	sendAjaxGet(ajaxString, populateReimbursement);

};

function populateReimbursement(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		for (var i = 0; i < res.length; i++) {

			var tableReimburse = document
					.getElementById("reimburseTableEmployee");
			var rowReimburseID = document.createElement("tr");
			rowReimburseID.setAttribute("class", "row100 body");
			tableReimburse.appendChild(rowReimburseID);

			var id = document.createElement("td");
			id.setAttribute("class", "cell100 column1");
			id.innerText = res[i].id;
			rowReimburseID.append(id);

			var table = document.getElementById("reimbursementTableBody");
			var row = document.createElement("tr");
			row.setAttribute("class", "row100 head");
			table.appendChild(row);

			var status = document.createElement("td");
			status.setAttribute("class", "cell100 column2");
			if (res[i].status == 1) {
				status.innerText = "Approved";
			} else if (res[i].status == 0) {
				status.innerText = "Pending";
			} else {
				status.innerText = "Denied";
			}

			var description = document.createElement("td");
			description.setAttribute("class", "cell100 column3");
			description.innerText = res[i].type;

			var value = document.createElement("td");
			value.setAttribute("class", "cell100 column4");
			value.innerText = res[i].value;

			var imageLinktd = document.createElement("td");
			var imageLink = document.createElement("button");

			imageLink.setAttribute("class", "cell100 column5");
			imageLink.setAttribute("id", res[i].id);
			imageLink.innerText = "View"
			imageLink.setAttribute("class", "btn btn-info active");
			imageLink.setAttribute("data-toggle", "modal");
			imageLink.setAttribute("data-target", "#exampleModalCenter");
			imageLink.onclick = getImage;

			imageLinktd.appendChild(imageLink);

			var accepttd = document.createElement("td");
			var accept = document.createElement("button");

			accept.setAttribute("class", "cell100 column6");
			accept.setAttribute("id", res[i].id);
			accept.innerText = "Accept"
			accept.setAttribute("class", "btn btn-info active");
			accept.onclick = acceptReimbursement;

			accepttd.appendChild(accept);

			var declinetd = document.createElement("td");
			var decline = document.createElement("button");

			decline.setAttribute("class", "cell100 column7");
			decline.setAttribute("id", res[i].id);
			decline.innerText = "Decline"
			decline.setAttribute("class", "btn btn-info active");
			decline.onclick = declineReimbursement;

			declinetd.appendChild(decline);

			if (res[i].status != 0) {
				row.append(status, description, value, imageLinktd);
			} else {
				row.append(status, description, value, imageLinktd, accepttd,
						declinetd);
			}
		}
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

function acceptReimbursement() {
	var url = "http://localhost:8084/Project1/data?entity=acceptRequest&get="
			+ this.id;
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		}
	};
	xhr.open("GET", url, true);
	xhr.send();

};

function declineReimbursement() {
	var url = "http://localhost:8084/Project1/data?entity=declineRequest&get="
			+ this.id;
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		}
	};
	xhr.open("GET", url, true);
	xhr.send();

};

function getImage() {
	var srcImage = "http://localhost:8084/Project1/image?reimburseID="
			+ this.id;
	var imgId = document.getElementById("currentReimbursementImage").src = srcImage;

};

window.onload = function() {
	sendAjaxGet(
			"http://localhost:8084/Project1/data?entity=employees&get=forManager",
			populateEmployee);
}