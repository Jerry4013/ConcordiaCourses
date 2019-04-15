// Exercise2.js - The JavaScript file for the solution to
//          Exercise 6.2

/* A function to move an element */

   function moveIt(movee, newTop, newLeft) {

     dom = document.getElementById(movee).style; 

/* Change the top and left properties to perform the move */

     dom.top = newTop + "px";
     dom.left = newLeft + "px";
   }
