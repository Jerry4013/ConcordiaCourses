// mover.js
//   Illustrates moving an element within a document
     
// The event handler function to move an element
function moveIt(movee, newTop, newLeft) {

  dom = document.getElementById(movee); 

// Change the top and left properties to perform the move
//  Note the addition of units to the input values 
  dom.style.top = newTop + "px";
  dom.style.left = newLeft + "px";
}
