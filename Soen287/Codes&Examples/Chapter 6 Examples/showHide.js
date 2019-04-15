// showHide.js
//   Illustrates visibility control of elements
     
// The event handler function to toggle the visibility 
//    of the images

function toggleImag() {
  dom = document.getElementById("squirrel").style;  

// Flip the visibility adjective to whatever it is not now 
 if (dom.visibility == "visible")
   dom.visibility = "hidden";
 else
   dom.visibility = "visible";
}
