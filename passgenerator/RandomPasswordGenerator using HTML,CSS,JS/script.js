//creating data sets for random pic
const upperSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const lowerSet = "abcdefghijklmnopqrstuvwxyz";
const numberSet = "1234567890";
const specialSet = "~!@#$%^&*();";


//selecting particular id's
const inputBox = document.getElementById("showpass");
const totalChar = document.getElementById("totalChar");
const uppercase = document.getElementById("uppercase");
const lowercase = document.getElementById("lowercase");
const numbers = document.getElementById("numbers");
const specialChar = document.getElementById("specialChar");

//generating random pass...
const getRandomData = (dataSet) => {
	return dataSet[Math.floor(Math.random() * dataSet.length)];
}


const getPassword = (password = "") => {
	if (uppercase.checked) {
		password += getRandomData(upperSet);
	}
	if (lowercase.checked) {
		password += getRandomData(lowerSet);
	}
	if (numbers.checked) {
		password += getRandomData(numberSet);
	}
	if (specialChar.checked) {
		password += getRandomData(specialSet);
	}

	//recursive function to increase characters
	if (password.length < totalChar.value) {
		return getPassword(password);
	}

	let pass = truncateString(password, totalChar.value);
	console.log(pass);
	inputBox.innerText = truncateString(password, totalChar.value);
	
}



document.getElementById("btn").addEventListener(
	"click", function () {
		getPassword();
	});

//controlling string according to user desire
function truncateString(str, num){  
	if (str.length > num) {
		let substr = str.substring(0, num);
		return substr;
	}else{
		return str;
	}
}