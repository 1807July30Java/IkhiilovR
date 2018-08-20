

window.onload = function(){
	getUSA();
	getPeopleInSales();	
	getAnchorChildren();
	getSkills();
	getCustomAttribute();
	sumEvent();
	skillsAlert();
	favoriteColorEvent();
	showHideEvent();
	currentTime();
	delayChangeColor();	
	walkTheDOM(document.body,function(node){
		console.log(node);
	});
}


/*
	Define function getUSA()

	Find the html element that contains "USA".

	Print that element's contents.
*/

function getUSA(){
	var spans = document.getElementsByTagName("span");
	for(var i=0;i<spans.length;i++){
  		if((spans[i].innerHTML) == "USA"){
  			console.log((spans[i]));
  		}
  		if(spans[i].getAttribute("data-customAttr") == "USA"){
  			console.log((spans[i]));
  		}
	}
};



/*
	2. Sales

	Define function getPeopleInSales()

	Print the names of all the people in the sales department.
*/

function getPeopleInSales(){

	var tds = document.getElementsByTagName("td");

	for(var i=0;i<tds.length;i++){
		if((tds[i].innerHTML) == "Sales"){
  			console.log(tds[i-1].innerHTML);
  		}
	}

};


/*

	3. Click Here

	Define function getAnchorChildren()

	Find all anchor elements with a <span> child.

	Print the contents of <span>
*/

function getAnchorChildren(){

	var anchors = document.getElementsByTagName("a");

	for (var i = 0; i < anchors.length; i++) {
		if(anchors[i].childNodes.length > 0){
			//console.log(anchors[i]);
			var child = anchors[i].childNodes
			for(j = 0; j < child.length;j++){
          		if(child[j].nodeName === "SPAN"){
          			console.log(child[j].textContent);
          		}
			}
		}
	}

};

/*

	4. Hobbies

	Define function getSkills()

	Find all checked options in the 'skills' select element.

	Print the value and the contents.
*/

function getSkills(){

	var skills = document.getElementsByName("skills");
 
    for(i = 0; i < skills.length; i ++){
      	var tab = skills[i];
      	for(j = 0; j < tab.length;j++){
      
        	if(tab[j].selected){
          		console.log(tab[j].textContent);
        }
      }
    }

};

/*
	5. Custom Attribute

	Define function getCustomAttribute()

	Find all elements with "data-customAttr" attribute

	Print the value of the attribute.

	Print the element that has the attribute.
*/

function getCustomAttribute(){

	var customAttr = document.querySelectorAll("[data-customAttr]");

    for (var i = 0, element; element = customAttr[i]; i++) {
    	// value 
      	console.log(element.innerText)
      	// element
      	console.log(element);
	}
};


/*

	6. Sum Event

	NOTE: Write unobtrusive Javascript

	Regarding these elements:
		
	<input id="num1" class="nums" type="text"/>
		
	<input id="num2" class="nums" type="text"/>
		
	<h3>Sum: span id="sum"></span></h3>

	Define onchange event handler.

	Add <input> element values.

	Put the sum in the <span> element.

	If values cannot be added, put "Cannot add" in the <span> element

*/


function sumEvent(){
  var num1 = document.getElementById("num1");
  var num2 = document.getElementById("num2");
  var sum = document.getElementById("sum");
  var numsSum = 0;

  num2.onchange = function(){
    numsSum = parseInt(num1.value, 10) + parseInt(num2.value, 10);

    sum.innerText = numsSum ? numsSum : "Cannot add.";
  
  };
};

/*

	7. Skills Event

	NOTE: Write unobtrusive Javascript

	When user selects a skill, create an alert with a message similar to:
		
	"Are you sure CSS is one of your skills?"

	NOTE: no alert should appear when user deselects a skill.


*/

function skillsAlert(){
  var skills = document.getElementsByName("skills");
  var s = skills[0];
  s.onchange = function(){
    alert("Are you sure " +  s.options[s.selectedIndex].text + " is one of your skills?")
  }
}

/*
	
	8. Favorite Color Event

	NOTE: Write unobtrusive Javascript

	NOTE: This is regarding the favoriteColor radio buttons.

	When a user selects a color, create an alert with a message similar to:
		
	"So you like green more than blue now?"

	In this example, green is the new value and blue is the old value.

	Make the background color (of all favoriteColor radio buttons) 
	the newly selected favoriteColor


*/

 function favoriteColorEvent() {
        var colors = document.getElementsByName("favoriteColor");

        for (var i = 0; i < colors.length; i++) {

            colors.item(i).addEventListener("change", function () {

                if(this.style.backgroundColor)
                	alert("So you like " + this.value + " more than " + this.style.backgroundColor + "?");
                for (var j = 0; j < colors.length; j++) {
                    colors.item(j).style.backgroundColor = this.value;
                }
            });
        }
    }

/*

	9. Show/Hide Event

	NOTE: Write unobtrusive Javascript

	When user hovers over an employees name:
		
	Hide the name if shown.
		Show the name if hidden.

*/

 function showHideEvent() {

	  var employees = document.getElementsByClassName("empName");

	  for(var i=0; i<employees.length; i++){
			element = employees[i];
	      	element.onmouseenter = function(){
	      		this.style.visibility =  "hidden";	
	      	}
	      	element.onmouseleave = function(){
	      		this.style.visibility = "visible";	
	      	}
	  }
	  
    };


/*

	10. Current Time

	Regarding this element:
		<h5 id="currentTime"></h5>

	Show the current time in this element in this format: 9:05:23 AM

	The time should be accurate to the second without having to reload the page.


*/

function currentTime(){

	var curTime = setInterval(function () {
        var currentTime = document.getElementById("currentTime");
        var time = new Date(Date.now());
        currentTime.innerText = time.toLocaleTimeString();
    }, 1000);

};



/*

	11. Delay
	Regarding this element:
		
	<p id="helloWorld">Hello, World!</p>

	Three seconds after a user clicks on this element, change the text to a random color.
*/

function delayChangeColor(){
  document.getElementById("helloWorld").addEventListener("click", function () {
        setTimeout(function () {
            var r = Math.floor(Math.random()*255);
            var g = Math.floor(Math.random()*255);
            var b = Math.floor(Math.random()*255);

            var rgb = "rgb("+ r +", "+ g +", "+ b +")";
            console.log("rgb colors: " + rgb);
            document.getElementById("helloWorld").style.color = rgb;
        }, 3000)
    });
};


/*

	12. Walk the DOM

	Define function walkTheDOM(node, func)

	This function should traverse every node in the DOM. 
	Use recursion.

	On each node, call func(node).


*/

 function walkTheDOM(node, func) {
 		// func node will be called for every node, in the windows load an anonymous function is passed to console log the node
        func(node);
        node = node.firstChild;
        while (node) {
            walkTheDOM(node, func);
            node = node.nextSibling;
        }
    };



