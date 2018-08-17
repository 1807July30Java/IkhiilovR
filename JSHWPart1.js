var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

	var fib = 1;
	var arr = [0,1];
	for (var i = 2; i <= n; i++) {
		arr.push((arr[i-2]+arr[i-1]));
	}
	if (n == 0){
		return 0;
	}
	if (n==1){
		return 1;
	}
	return arr[n];
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {

	//bubble sort
	var len = array.length;
	for (var i = 0; i < len; i++) {
		for (var j = 0; j < len - i; j++) {
			 if (array[j] > array[j+1]){
                   
                    var temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
              }
		}
	}

	return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){

	if(n == 0)
		return 1;
	var arr = [1];

	for (var i = 1; i <= n; i++) {
		arr.push((arr[i-1] * i))
	}

	return arr[n];
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {

	for (var i = 0; i < n; i++) {
  		array.push(array.shift());
  	}

	return array;

};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){

	if (bracketsString.length % 2 == 1)
		return false;

	var left = "({[";
	var right = ")}]";
	var stack = [];

	for (var i = 0; i < bracketsString.length; i++) {
		var current  = bracketsString[i];

		if(left.includes(current)){
			stack.push(current);
		}else if (right.includes(current)){
			var popped = stack.pop();
			if (current == ")" && popped != "(" )
				return false;
			if (current == "}" && popped != "{" )
				return false;
			if (current == "]" && popped != "[" )
				return false;

		}
	}
	return stack.length === 0;
};


//YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
