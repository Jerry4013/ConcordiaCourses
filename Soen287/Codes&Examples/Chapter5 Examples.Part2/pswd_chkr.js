// pswd_chkr.js
//   Register the event handlers for pswd_chk.html
     
document.getElementById("second").onblur = chkPasswords; 
document.getElementById("myForm").onsubmit = chkPasswords;


/*Using event listener*/
//document.getElementById("second").addEventListener ("blur", chkPasswords); 
//document.getElementById("myForm").addEventListener("submit", chkPasswords);



