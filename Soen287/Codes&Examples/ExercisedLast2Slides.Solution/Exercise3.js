
// Exercise3.js - The JavaScript part of a solution to
//          Exercise 6.3

/* A function to change the visibility of an element */

   function flipImage(img) {

     dom = document.getElementById(img).style; 

/* Change the visibility property */

     if (dom.visibility == "visible")
         dom.visibility = "hidden";
     else
         dom.visibility = "visible";
   }
