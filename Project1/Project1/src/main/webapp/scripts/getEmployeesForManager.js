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
			
			var tableUsername = document.getElementById("employeeTableUsername");
            var rowUsername = document.createElement("tr");
            rowUsername.setAttribute("class", "row100 body");
            tableUsername.appendChild(rowUsername);
            
            var username = document.createElement("td");
            username.setAttribute("class", "cell100 column1" );
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
            
            row.append(firstName, lastName, email, password);
            
            
        }
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project1/data?entity=employees&get=forManager", populateEmployee);
}