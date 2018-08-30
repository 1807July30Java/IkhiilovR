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
		if (res.isManager == 1) {
			var nav = document.getElementById("employeesNav");
			nav.style.display = 'block';
			var navR = document.getElementById("registerNav");
			navR.style.display = 'block';
		}
		if (res.username) {
			var ajaxString = "http://localhost:8084/Project1/data?entity=allReimbursements&get=" + res.id;
			sendAjaxGet(ajaxString, populateReimbursement);
		}
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project1/session", populateEmployee);
}

function populateReimbursement(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		for (var i = 0; i < res.length; i++) {
			
			var tableReimburse = document.getElementById("reimburseTableEmployee");
            var rowReimburseID = document.createElement("tr");
            rowReimburseID.setAttribute("class", "row100 body");
            tableReimburse.appendChild(rowReimburseID);
            
            var id = document.createElement("td");
            id.setAttribute("class", "cell100 column1" );
            id.innerText = res[i].id;
            rowReimburseID.append(id);
			
            var table = document.getElementById("reimbursementTableBody");
            var row = document.createElement("tr");
            row.setAttribute("class", "row100 head");
            table.appendChild(row);
            
            var status = document.createElement("td");
            status.setAttribute("class", "cell100 column2");
            if(res[i].status == 1){
            	status.innerText = "Approved";
            }else if(res[i].status == 0){
            	status.innerText = "Pending";
            }else{
            	status.innerText = "Denied";
            }
            
            
            var description = document.createElement("td");
            description.setAttribute("class", "cell100 column3");
            description.innerText = res[i].type;
            
            var value = document.createElement("td"); 
            value.setAttribute("class", "cell100 column4");
            value.innerText = res[i].value;
            
            var imageLink = document.createElement("button");
            
            imageLink.setAttribute("class", "cell100 column5");
            imageLink.setAttribute("id", res[i].id);
            imageLink.style.textAlign = "center";
            imageLink.innerText = "View"
            imageLink.setAttribute("class", "btn btn-info active");
            imageLink.setAttribute("data-toggle", "modal");
            imageLink.setAttribute("data-target", "#exampleModalCenter");
            imageLink.onclick = getImage;
        
            
            row.append(status, description, value, imageLink);
            
            
        }
	} else {
		window.location = "http://localhost:8084/Project1/login";
	}
};

function getImage(){
	var srcImage = "http://localhost:8084/Project1/image?reimburseID=" +this.id;
	var imgId = document.getElementById("currentReimbursementImage").src =  srcImage;
	
	
	
	
};