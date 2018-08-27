/**
 * 
 */

var input = document.querySelector('input[type=file]');
function changeFile() {
	  var file = input.files[0];
	  var reader = new FileReader();
	  reader.addEventListener('load', readFile);
	  reader.readAsText(file);
	}

	input.addEventListener('change', changeFile);
	
	function readFile(event) {
		  //document.body.textContent = event.target.result
		  console.log(event.target.result);
		}
	
	function previewFile() {
		var preview = document.querySelector('img');
		var file = document.querySelector('input[type=file]').files[0];
		var reader = new FileReader();

		reader.addEventListener("load", function () {preview.src = reader.result;}, false);
		if (file) {
			reader.readAsDataURL(file);
			}
		}