
//setting selectors
const loadText = document.querySelector(".loading");
const background = document.querySelector(".background");


// console.log(background.innerText)
let load = 0;
let int = setInterval(blurring, 50);

function blurring(){
	load++;

	if (load > 125) {
		clearInterval(int);
	}
	// console.log(load);
	loadText.innerText = `${load}%` ;
	loadText.style.opacity = scale(load, 0, 100, 1, 0);
	background.style.filter = `blur(${scale(load, 0, 100, 3, 0)}px)`
	

}

//from stack overflow to set opacity and blur
let scale = (load, min, max, start_opacity, end_opacity) => {
		return (load - min) * (end_opacity - start_opacity) / (max - min) + start_opacity;
	}

